package com.example.servingwebcontent.utils;

public class Sequence<T> {
    private Object[] objects;
    private int next = 0;

    // Constructor: Khởi tạo dãy đối tượng
    public Sequence(int size) {
        objects = new Object[size];
    }

    // Thêm đối tượng vào dãy
    public void add(T x) {
        if (next < objects.length) {
            objects[next++] = x;
        }
    }

    // Lớp SSelector bên trong để thực hiện Selector
    class SSelector implements Selector {
        private int i = 0;

        // Kiểm tra xem đã duyệt hết các đối tượng chưa
        public boolean end() {
            return i == next;
        }

        // Lấy đối tượng hiện tại
        public Object current() {
            return objects[i];
        }

        // Di chuyển đến đối tượng tiếp theo
        public void next() {
            if (i < next) i++;
        }
    }

    // Trả về một đối tượng Selector để duyệt qua dãy đối tượng
    public Selector getSelector() {
        return new SSelector();
    }
}
