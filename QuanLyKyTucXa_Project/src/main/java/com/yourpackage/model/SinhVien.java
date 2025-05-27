public class SinhVien {
    String maSinhVien;
    String hoTen;
    String ngaySinh;
    String gioiTinh;
    String soDienThoai;
    String lopHoc;

    public SinhVien(String maSinhVien, String hoTen, String ngaySinh, String gioiTinh, String soDienThoai, String lopHoc) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.lopHoc = lopHoc;
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

    public void hienThiThongTin() {
        System.out.println("Ma SV: " + maSinhVien + ", Ho ten: " + hoTen + ", Lop: " + lopHoc);
    }
}