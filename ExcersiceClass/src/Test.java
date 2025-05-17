public class Test {
    private String maSinhVien;
    private String hoTen;
    private String lopHoc;

    // Constructor
    public Test(String maSinhVien, String hoTen, String lopHoc) {
        this.maSinhVien = maSinhVien;
        this.hoTen      = hoTen;
        this.lopHoc     = lopHoc;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }
    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLopHoc() {
        return lopHoc;
    }
    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }
}
