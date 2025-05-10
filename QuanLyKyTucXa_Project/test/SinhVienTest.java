import org.junit.jupiter.api.Test; // Import cua JUnit 5
import static org.junit.jupiter.api.Assertions.*; // Import cac ham assert cua JUnit 5

public class SinhVienTest {

    @Test
    void testTaoSinhVienVaGetHoTen() {
        // Tao mot doi tuong SinhVien moi
        SinhVien sv = new SinhVien("SV001", "Nguyen Van A", "01/01/2000", "Nam", "090xxxxxxx", "CNTT01");
        // Kiem tra xem phuong thuc getHoTen() co tra ve dung ten hay khong
        assertEquals("Nguyen Van A", sv.getHoTen(), "Ho ten sinh vien khong dung.");
        // Kiem tra xem phuong thuc getMaSinhVien() co tra ve dung ma sinh vien hay khong
        assertEquals("SV001", sv.getMaSinhVien());
    }

    @Test
    void testSetHoTen() {
        // Tao mot doi tuong SinhVien moi
        SinhVien sv = new SinhVien("SV002", "Tran Thi B", "02/02/2001", "Nu", "091xxxxxxx", "KT02");
        // Thay doi ho ten cua sinh vien
        sv.setHoTen("Nguyen Van B");
        // Kiem tra xem ho ten da duoc cap nhat dung hay chua
        assertEquals("Nguyen Van B", sv.getHoTen(), "Cap nhat ho ten khong thanh cong.");
    }
}
