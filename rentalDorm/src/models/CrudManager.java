package models;

import java.util.ArrayList;
import java.util.List;

public class CrudManager<T extends Identifiable> {
    private List<T> items = new ArrayList<>(); // Danh sách các đối tượng được quản lý

    // Create: thêm đối tượng mới vào danh sách
    public void add(T item) {
        items.add(item);
        System.out.println("Đã thêm: " + item.getID());
    }

    // Read: hiển thị tất cả đối tượng
    public void readAll() {
        if (items.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (T item : items) {
            System.out.println(item);
        }
    }

    // Update: cập nhật đối tượng theo ID (thay thế bằng đối tượng mới)
    public void update(String id, T newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID().equals(id)) {
                items.set(i, newItem);
                System.out.println("Đã cập nhật: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy ID: " + id);
    }

    // Delete: xóa đối tượng theo ID
    public void delete(String id) {
        for (T item : items) {
            if (item.getID().equals(id)) {
                items.remove(item);
                System.out.println("Đã xóa: " + id);
                return;
            }
        }
        System.out.println("Không tìm thấy ID: " + id);
    }

    // Getter: lấy danh sách các đối tượng
    public List<T> getItems() {
        return items;
    }

    // Getter: lấy đối tượng theo ID
    public T getItemById(String id) {
        for (T item : items) {
            if (item.getID().equals(id)) {
                return item;
            }
        }
        return null;  // Nếu không tìm thấy
    }
}
