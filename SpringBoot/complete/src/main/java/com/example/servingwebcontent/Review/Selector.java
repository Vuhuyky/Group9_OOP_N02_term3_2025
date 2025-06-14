package Review;

public interface Selector {
    boolean end();        // Kiểm tra xem đã đến phần tử cuối cùng trong chuỗi chưa
    Object current();     // Lấy đối tượng hiện tại
    void next();          // Di chuyển đến đối tượng tiếp theo
}
