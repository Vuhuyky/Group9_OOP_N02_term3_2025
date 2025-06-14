import java.util.Scanner;
import models.DormRoom;
import models.Student;
import models.RentalContract;
import models.CrudManager;
import CRUD.PrintList;
import CRUD.Search;
import CRUD.Output;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo CrudManager cho các đối tượng
        CrudManager<DormRoom> dormRoomManager = new CrudManager<>();
        CrudManager<Student> studentManager = new CrudManager<>();
        CrudManager<RentalContract> rentalContractManager = new CrudManager<>();

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
                    manageDormRooms(dormRoomManager, studentManager, scanner);
                    break;
                case 2:
                    manageStudents(studentManager, scanner);
                    break;
                case 3:
                    manageRentalContracts(rentalContractManager, studentManager, dormRoomManager, scanner);
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
    private static void manageDormRooms(CrudManager<DormRoom> dormRoomManager, 
                                        CrudManager<Student> studentManager, 
                                        Scanner scanner) {
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
                addDormRoom(dormRoomManager, scanner);
                break;
            case 2:
                PrintList.hienThiBangPhong(dormRoomManager);
                break;
            case 3:
                assignStudentToRoom(dormRoomManager, studentManager, scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    // Thêm phòng mới
    private static void addDormRoom(CrudManager<DormRoom> dormRoomManager, Scanner scanner) {
        System.out.print("Nhập Room ID: ");
        String dormRoomID = scanner.nextLine();
        System.out.print("Nhập Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print("Nhập Building: ");
        String building = scanner.nextLine();
        System.out.print("Nhập Room Status (available/occupied): ");
        String roomStatus = scanner.nextLine();

        DormRoom dormRoom = new DormRoom(dormRoomID, price, building, roomStatus);
        dormRoomManager.add(dormRoom);
        System.out.println("Phòng ký túc xá đã được thêm!");
    }

    // Gán sinh viên vào phòng
    private static void assignStudentToRoom(CrudManager<DormRoom> dormRoomManager, 
                                             CrudManager<Student> studentManager, 
                                             Scanner scanner) {
        System.out.print("Nhập Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Nhập Dorm Room ID: ");
        String dormRoomID = scanner.nextLine();

        // Tìm sinh viên và phòng theo ID
        Student student = studentManager.getItemById(studentID);
        DormRoom dormRoom = dormRoomManager.getItemById(dormRoomID);

        // Kiểm tra nếu sinh viên và phòng có tồn tại
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên với ID: " + studentID);
            return;
        }
        if (dormRoom == null) {
            System.out.println("Không tìm thấy phòng với ID: " + dormRoomID);
            return;
        }

        // Gán sinh viên vào phòng
        dormRoom.assignStudent(studentID);  // Gán sinh viên vào phòng
        student.setDormRoomID(dormRoomID);
        System.out.println("Sinh viên " + student.getName() + " đã được gán vào phòng " + dormRoomID);
    }

    // Quản lý sinh viên
    private static void manageStudents(CrudManager<Student> studentManager, Scanner scanner) {
        System.out.println("---- Quản lý sinh viên ----");
        System.out.println("1. Thêm sinh viên mới");
        System.out.println("2. Hiển thị danh sách sinh viên");
        System.out.println("3. Trở lại");
        System.out.print("Chọn chức năng (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addStudent(studentManager, scanner);
                break;
            case 2:
                PrintList.hienThiDanhSachSinhVien(studentManager);
                break;
            case 3:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    // Thêm sinh viên mới
    private static void addStudent(CrudManager<Student> studentManager, Scanner scanner) {
        System.out.print("Nhập Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Nhập Name: ");
        String name = scanner.nextLine();
        System.out.print("Nhập Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Nhập Dorm Room ID: ");
        String dormRoomID = scanner.nextLine();

        Student student = new Student(studentID, name, phoneNumber, dormRoomID);
        studentManager.add(student);
        System.out.println("Sinh viên đã được thêm!");
    }

    // Quản lý hợp đồng thuê phòng
    private static void manageRentalContracts(CrudManager<RentalContract> rentalContractManager, 
                                               CrudManager<Student> studentManager, 
                                               CrudManager<DormRoom> dormRoomManager, 
                                               Scanner scanner) {
        System.out.println("---- Quản lý hợp đồng thuê phòng ----");
        System.out.println("1. Thêm hợp đồng mới");
        System.out.println("2. Hiển thị danh sách hợp đồng");
        System.out.println("3. Trở lại");
        System.out.print("Chọn chức năng (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addRentalContract(rentalContractManager, studentManager, dormRoomManager, scanner);
                break;
            case 2:
                PrintList.hienThiDanhSachHopDong(rentalContractManager);
                break;
            case 3:
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }

    // Thêm hợp đồng mới
    private static void addRentalContract(CrudManager<RentalContract> rentalContractManager, 
                                           CrudManager<Student> studentManager, 
                                           CrudManager<DormRoom> dormRoomManager, 
                                           Scanner scanner) {
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

        // Giả sử rằng bạn có cách để chuyển đổi String thành LocalDate
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        // Tạo đối tượng Student và DormRoom từ ID tương ứng (giả sử đã có)
        Student student = studentManager.getItemById(studentID);  // Tìm kiếm sinh viên theo ID
        DormRoom dormRoom = dormRoomManager.getItemById(dormRoomID);  // Tìm kiếm phòng theo ID

        // Kiểm tra nếu không tìm thấy sinh viên hoặc phòng
        if (student == null || dormRoom == null) {
            System.out.println("Không tìm thấy sinh viên hoặc phòng ký túc xá.");
            return;
        }

        // Tạo hợp đồng thuê phòng
        RentalContract rentalContract = new RentalContract(contractID, student, dormRoom, startDate, endDate);
        rentalContractManager.add(rentalContract);  // Thêm hợp đồng vào quản lý
        System.out.println("Hợp đồng thuê phòng đã được thêm!");
    }
}
