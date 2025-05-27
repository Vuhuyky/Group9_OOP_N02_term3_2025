public class PhongO {
    String maPhong;
    String toaNha;
    int sucChua;
    String loaiPhong;
    double giaPhong;
    int soNguoiHienTai;

    public PhongO(String maPhong, String toaNha, int sucChua, String loaiPhong, double giaPhong) {
        this.maPhong = maPhong;
        this.toaNha = toaNha;
        this.sucChua = sucChua;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.soNguoiHienTai = 0; // Khởi tạo ban đầu chưa có ai
    }

    // Getters and Setters
    public String getMaPhong() {
        return maPhong;
    }

    public boolean conTrong() {
        return soNguoiHienTai < sucChua;
    }

    public void themNguoi() {
        if (conTrong()) {
            this.soNguoiHienTai++;
        } else {
            System.out.println("Phong " + maPhong + " da day");
        }
    }

    public void botNguoi() {
        if (this.soNguoiHienTai > 0) {
            this.soNguoiHienTai--;
        }
    }
}