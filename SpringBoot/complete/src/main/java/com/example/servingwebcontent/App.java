import java.util.Scanner;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo RestTemplate để gọi API
        RestTemplate restTemplate = new RestTemplate();
        
        while (true) {
            // Menu chính
            System.out.println("\n---- Hệ thống quản lý ký túc xá ----");
            System.out.println("1. Quản lý phòng ký túc xá");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Quản lý hợp đồng thuê phòng");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    manageDormRooms(restTemplate, scanner);
                    break;
                case 2:
                    manageStudents(restTemplate, scanner);
                    break;
                case 3:
                    manageRentalContracts(restTemplate, scanner);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    // Quản lý phòng ký túc xá
    private static void manageDormRooms(RestTemplate restTemplate, Scanner scanner) {
        System.out.println("---- Quản lý phòng ký túc xá ----");
        System.out.println("1. Thêm phòng mới");
        System.out.println("2. Hiển thị danh sách phòng");
        System.out.println("3. Gán sinh viên vào phòng");
        System.out.println("4. Trở lại");
        System.out.print("Chọn chức năng (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addDormRoom(restTemplate, scanner);
                break;
            case 2:
                displayDormRooms(restTemplate);
                break;
            case 3:
                assignStudentToRoom(restTemplate, scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    // Thêm phòng mới
    private static void addDormRoom(RestTemplate restTemplate, Scanner scanner) {
        System.out.print("Nhập Room ID: ");
        String dormRoomID = scanner.nextLine();
        System.out.print("Nhập Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print("Nhập Building: ");
        String building = scanner.nextLine();
        System.out.print("Nhập Room Status (available/occupied): ");
        String roomStatus = scanner.nextLine();

        // Tạo đối tượng DormRoom và gửi đến API
        DormRoom dormRoom = new DormRoom(dormRoomID, price, building, roomStatus);
        restTemplate.postForObject("http://localhost:8080/dormrooms", dormRoom, DormRoom.class);
        System.out.println("Phòng ký túc xá đã được thêm!");
    }

    // Hiển thị danh sách phòng ký túc xá
    private static void displayDormRooms(RestTemplate restTemplate) {
        ResponseEntity<List<DormRoom>> dormRoomsResponse = restTemplate.exchange(
            "http://localhost:8080/dormrooms", 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<DormRoom>>() {}
        );
        
        List<DormRoom> dormRooms = dormRoomsResponse.getBody();
        dormRooms.forEach(dormRoom -> System.out.println(dormRoom));
    }

    // Gán sinh viên vào phòng
    private static void assignStudentToRoom(RestTemplate restTemplate, Scanner scanner) {
        System.out.print("Nhập Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Nhập Dorm Room ID: ");
        String dormRoomID = scanner.nextLine();

        // Lấy sinh viên và phòng từ API
        Student student = restTemplate.getForObject("http://localhost:8080/students/" + studentID, Student.class);
        DormRoom dormRoom = restTemplate.getForObject("http://localhost:8080/dormrooms/" + dormRoomID, DormRoom.class);

        if (student == null || dormRoom == null) {
            System.out.println("Không tìm thấy sinh viên hoặc phòng.");
            return;
        }

        // Gán sinh viên vào phòng
        dormRoom.assignStudent(studentID);  // Gán sinh viên vào phòng
        student.setDormRoomID(dormRoomID);
        restTemplate.put("http://localhost:8080/students/" + studentID, student);
        restTemplate.put("http://localhost:8080/dormrooms/" + dormRoomID, dormRoom);

        System.out.println("Sinh viên " + student.getName() + " đã được gán vào phòng " + dormRoomID);
    }

    // Quản lý sinh viên
    private static void manageStudents(RestTemplate restTemplate, Scanner scanner) {
        System.out.println("---- Quản lý sinh viên ----");
        System.out.println("1. Thêm sinh viên mới");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Trở lại");
        System.out.print("Chọn chức năng (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addStudent(restTemplate, scanner);
                break;
            case 2:
                displayStudents(restTemplate);
                break;
            case 3:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    // Thêm sinh viên mới
    private static void addStudent(RestTemplate restTemplate, Scanner scanner) {
        System.out.print("Nhập Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Nhập Name: ");
        String name = scanner.nextLine();
        System.out.print("Nhập Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập Dorm Room ID: ");
        String dormRoomID = scanner.nextLine();

        // Tạo đối tượng Student và gửi đến API
        Student student = new Student(studentID, name, phoneNumber, dormRoomID);
        restTemplate.postForObject("http://localhost:8080/students", student, Student.class);
        System.out.println("Sinh viên đã được thêm!");
    }

    // Hiển thị danh sách sinh viên
    private static void displayStudents(RestTemplate restTemplate) {
        ResponseEntity<List<Student>> studentsResponse = restTemplate.exchange(
            "http://localhost:8080/students", 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<Student>>() {}
        );
        
        List<Student> students = studentsResponse.getBody();
        students.forEach(student -> System.out.println(student));
    }

    // Quản lý hợp đồng thuê phòng
    private static void manageRentalContracts(RestTemplate restTemplate, Scanner scanner) {
        System.out.println("---- Quản lý hợp đồng thuê phòng ----");
        System.out.println("1. Thêm hợp đồng mới");
        System.out.println("2. Hiển thị danh sách hợp đồng");
        System.out.println("3. Trở lại");
        System.out.print("Chọn chức năng (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addRentalContract(restTemplate, scanner);
                break;
            case 2:
                displayRentalContracts(restTemplate);
                break;
            case 3:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    // Thêm hợp đồng mới
    private static void addRentalContract(RestTemplate restTemplate, Scanner scanner) {
        System.out.print("Nhập Contract ID: ");
        String contractID = scanner.nextLine();
        System.out.print("Nhập Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Nhập Dorm Room ID: ");
        String dormRoomID = scanner.nextLine();
        System.out.print("Nhập Start Date (yyyy-mm-dd): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Nhập End Date (yyyy-mm-dd): ");
        String endDateStr = scanner.nextLine();

        // Chuyển đổi String thành LocalDate
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Lấy sinh viên và phòng từ API
        Student student = restTemplate.getForObject("http://localhost:8080/students/" + studentID, Student.class);
        DormRoom dormRoom = restTemplate.getForObject("http://localhost:8080/dormrooms/" + dormRoomID, DormRoom.class);

        if (student == null || dormRoom == null) {
            System.out.println("Không tìm thấy sinh viên hoặc phòng.");
            return;
        }

        // Tạo hợp đồng thuê phòng
        RentalContract rentalContract = new RentalContract(contractID, student, dormRoom, startDate, endDate);
        restTemplate.postForObject("http://localhost:8080/rentalcontracts", rentalContract, RentalContract.class);
        System.out.println("Hợp đồng thuê phòng đã được thêm!");
    }

    // Hiển thị danh sách hợp đồng
    private static void displayRentalContracts(RestTemplate restTemplate) {
        ResponseEntity<List<RentalContract>> rentalContractsResponse = restTemplate.exchange(
            "http://localhost:8080/rentalcontracts", 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<RentalContract>>() {}
        );
        
        List<RentalContract> rentalContracts = rentalContractsResponse.getBody();
        rentalContracts.forEach(contract -> System.out.println(contract));
    }
}
