package com.group9;

import java.util.Scanner;
import com.group9.model.Student;
import com.group9.service.StudentList;

public class TestStudent {
    public static void main(String[] args) {
        StudentList stuList = new StudentList();
        // Khởi tạo mẫu
        stuList.addStudent(new Student("Nguyen Thi Lan Anh", 12345));
        stuList.addStudent(new Student("Tran Van Minh",     2));
        stuList.addStudent(new Student("Nguyen An",       101010));

        Scanner sc = new Scanner(System.in);

        System.out.println("Danh sách sinh viên ban đầu:");
        stuList.printStudentList();

        // Cập nhật
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int editId = sc.nextInt(); sc.nextLine();
        System.out.print("Nhập tên mới: ");
        String newName = sc.nextLine();
        stuList.editStudent(editId, newName);
        System.out.println("Sau khi cập nhật:");
        stuList.printStudentList();

        // Xoá
        System.out.print("Nhập ID sinh viên cần xóa: ");
        int delId = sc.nextInt();
        stuList.deleteStudent(delId);
        System.out.println("Sau khi xóa:");
        stuList.printStudentList();

        sc.close();
    }
}
