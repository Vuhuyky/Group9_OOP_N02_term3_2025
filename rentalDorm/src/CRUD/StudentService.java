package services;

import models.Student;
import models.CrudManager;

public class StudentService {
    private CrudManager<Student> studentManager = new CrudManager<>();

    public void createStudent(Student student) {
        studentManager.create(student);
    }

    public void listAllStudents() {
        studentManager.readAll();
    }

    public void updateStudent(String studentID, Student newStudent) {
        studentManager.update(studentID, newStudent);
    }

    public void deleteStudent(String studentID) {
        studentManager.delete(studentID);
    }

    public CrudManager<Student> getStudentManager() {
        return studentManager;
    }
}
