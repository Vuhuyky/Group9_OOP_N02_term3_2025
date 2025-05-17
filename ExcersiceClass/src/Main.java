public class Main {
    public static void main(String[] args) {
        Test a = new Test("123456789", "VHK", "CNTT5");

        System.out.println(
            a.getHoTen() + " "+ a.getMaSinhVien()  + " " + a.getLopHoc()
        );
    }
}
