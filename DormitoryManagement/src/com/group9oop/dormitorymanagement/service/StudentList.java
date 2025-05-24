// StudentList.java
import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> st = new ArrayList<>();

    public ArrayList<Student> addStudent(Student stu) {
        st.add(stu);
        return st;
    }

    public ArrayList<Student> editStudent(int studentID, String newFullname) {
        for (Student s : st) {
            if (s.studentId == studentID) {
                s.fullname = newFullname;
                break;
            }
        }
        return st;
    }

    public ArrayList<Student> deleteStudent(int studentID) {
        st.removeIf(s -> s.studentId == studentID);
        return st;
    }

    public void printStudentList() {
        System.out.println("=== Student List ===");
        for (Student s : st) {
            System.out.printf("ID: %d – Name: %s\n", s.studentId, s.fullname);
        }
    }
}
