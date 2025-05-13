// src/Main.java
public class Main {
    public static void main(String[] args) {
        // Khởi tạo Student qua constructor
        Test a = new Test("22010414", "VHK", "CNTT5");
        
        // In ra trực tiếp các trường
        System.out.println(a.hoTen + " " + a.maSinhvien + " " + a.lopHoc);
    }
}
