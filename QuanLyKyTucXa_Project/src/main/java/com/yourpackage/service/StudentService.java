public class StudentService extends GenericService<Student, String> {

    @Override
    protected String getId(Student obj) {
        return obj.getStudentId(); // giả sử Student có method getStudentId()
    }

    // Các hàm lọc sinh viên theo lớp, khoa
}
