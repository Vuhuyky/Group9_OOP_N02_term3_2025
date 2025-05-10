public class DangKyPhong {
    String maDangKy;
    
    SinhVien sinhVien;
    PhongO phongO;
    String ngayDangKy;
    String ngayBatDauO;
    String ngayKetThucDuKien;

    public DangKyPhong(String maDangKy, SinhVien sinhVien, PhongO phongO, String ngayDangKy, String ngayBatDauO, String ngayKetThucDuKien) {
        this.maDangKy = maDangKy;
        this.sinhVien = sinhVien;
        this.phongO = phongO;
        this.ngayDangKy = ngayDangKy;
        this.ngayBatDauO = ngayBatDauO;
        this.ngayKetThucDuKien = ngayKetThucDuKien;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void hienThiThongTinDangKy() {
        System.out.println("Ma ĐK: " + maDangKy +
                           ", SV: " + sinhVien.getHoTen() + " (Ma SV: " + sinhVien.getMaSinhVien() + ")" +
                           ", Phong: " + phongO.getMaPhong() +
                           ", Ngay ĐK: " + ngayDangKy);
    }
}