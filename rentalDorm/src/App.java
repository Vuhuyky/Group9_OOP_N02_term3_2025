import java.util.Scanner;
import models.DormRoom;
import models.Student;
import models.RentalContract;
import models.CrudManager;
import CRUD.PrintList;
import CRUD.Search;
import CRUD.Output;

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

    // Các phương thức quản lý khác (dormRooms, students, rentalContracts)
}
