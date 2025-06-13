import java.util.Scanner;
import models.DormRoom;
import models.Student;
import models.RentalContract;
import models.CrudManager;
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
                    manageDormRooms(dormRoomManager, scanner);
                    break;
                case 2:
                    manageStudents(studentManager, scanner);
                    break;
                case 3:
                    manageRentalContracts(rentalContractManager, scanner);
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
    private static void manageDormRooms(CrudManager<DormRoom> dormRoomManager, Scanner scanner) {
        System.out.println("\n--- Quản lý phòng ký túc xá ---");
        System.out.println("1. Thêm phòng");
        System.out.println("2. Liệt kê phòng");
        System.out.println("3. Cập nhật phòng");
        System.out.println("4. Xóa phòng");
        System.out.print("Chọn chức năng (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                // Thêm phòng
                System.out.print("Nhập ID phòng: ");
                String dormRoomID = scanner.nextLine();
                System.out.print("Nhập giá phòng: ");
                double price = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                System.out.print("Nhập tòa nhà: ");
                String building = scanner.nextLine();
                System.out.print("Nhập trạng thái phòng (available/occupied): ");
                String roomStatus = scanner.nextLine();

                DormRoom dormRoom = new DormRoom(dormRoomID, price, building, roomStatus);
                dormRoomManager.create(dormRoom);
                break;

            case 2:
                // Liệt kê phòng
                dormRoomManager.readAll();
                break;

            case 3:
                // Cập nhật phòng
                System.out.print("Nhập ID phòng để cập nhật: ");
                String updateDormRoomID = scanner.nextLine();
                System.out.print("Nhập trạng thái mới (available/occupied): ");
                String newRoomStatus = scanner.nextLine();

                DormRoom updatedDormRoom = new DormRoom(updateDormRoomID, 0, "", newRoomStatus);
                dormRoomManager.update(updateDormRoomID, updatedDormRoom);
                break;

            case 4:
                // Xóa phòng
                System.out.print("Nhập ID phòng để xóa: ");
                String deleteDormRoomID = scanner.nextLine();
                dormRoomManager.delete(deleteDormRoomID);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    // Quản lý sinh viên
    private static void manageStudents(CrudManager<Student> studentManager, Scanner scanner) {
        System.out.println("\n--- Quản lý sinh viên ---");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Liệt kê sinh viên");
        System.out.println("3. Cập nhật sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.print("Chọn chức năng (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                // Thêm sinh viên
                System.out.print("Nhập mã sinh viên: ");
                String studentID = scanner.nextLine();
                System.out.print("Nhập tên sinh viên: ");
                String name = scanner.nextLine();
                System.out.print("Nhập số điện thoại: ");
                String phone = scanner.nextLine();
                System.out.print("Nhập ID phòng ký túc xá: ");
                String dormRoomID = scanner.nextLine();

                Student student = new Student(studentID, name, phone, dormRoomID);
                studentManager.create(student);
                break;

            case 2:
                // Liệt kê sinh viên
                studentManager.readAll();
                break;

            case 3:
                // Cập nhật sinh viên
                System.out.print("Nhập ID sinh viên để cập nhật: ");
                String updateStudentID = scanner.nextLine();
                System.out.print("Nhập ID phòng ký túc xá mới: ");
                String newDormRoomID = scanner.nextLine();

                Student updatedStudent = new Student(updateStudentID, "", "", newDormRoomID);
                studentManager.update(updateStudentID, updatedStudent);
                break;

            case 4:
                // Xóa sinh viên
                System.out.print("Nhập ID sinh viên để xóa: ");
                String deleteStudentID = scanner.nextLine();
                studentManager.delete(deleteStudentID);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }

    // Quản lý hợp đồng thuê phòng
    private static void manageRentalContracts(CrudManager<RentalContract> rentalContractManager, Scanner scanner) {
        System.out.println("\n--- Quản lý hợp đồng thuê phòng ---");
        System.out.println("1. Thêm hợp đồng");
        System.out.println("2. Liệt kê hợp đồng");
        System.out.println("3. Cập nhật hợp đồng");
        System.out.println("4. Xóa hợp đồng");
        System.out.print("Chọn chức năng (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                // Thêm hợp đồng
                System.out.print("Nhập ID hợp đồng: ");
                String contractID = scanner.nextLine();
                System.out.print("Nhập mã sinh viên: ");
                String studentID = scanner.nextLine();
                System.out.print("Nhập mã phòng: ");
                String dormRoomID = scanner.nextLine();
                System.out.print("Nhập ngày bắt đầu hợp đồng (yyyy-mm-dd): ");
                String startDate = scanner.nextLine();
                System.out.print("Nhập ngày kết thúc hợp đồng (yyyy-mm-dd): ");
                String endDate = scanner.nextLine();

                RentalContract rentalContract = new RentalContract(contractID, studentID, dormRoomID, LocalDate.parse(startDate), LocalDate.parse(endDate));
                rentalContractManager.create(rentalContract);
                break;

            case 2:
                // Liệt kê hợp đồng
                rentalContractManager.readAll();
                break;

            case 3:
                // Cập nhật hợp đồng
                System.out.print("Nhập ID hợp đồng để cập nhật: ");
                String updateContractID = scanner.nextLine();
                System.out.print("Nhập ngày kết thúc hợp đồng mới: ");
                String newEndDate = scanner.nextLine();
                RentalContract updatedRentalContract = new RentalContract(updateContractID, studentID, dormRoomID, LocalDate.now(), LocalDate.parse(newEndDate));
                rentalContractManager.update(updateContractID, updatedRentalContract);
                break;

            case 4:
                // Xóa hợp đồng
                System.out.print("Nhập ID hợp đồng để xóa: ");
                String deleteContractID = scanner.nextLine();
                rentalContractManager.delete(deleteContractID);
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
    }
}
