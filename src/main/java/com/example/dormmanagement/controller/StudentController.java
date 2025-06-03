package com.example.dormmanagement.controller;

import com.example.dormmanagement.exception.ResourceNotFoundException;
import com.example.dormmanagement.model.Room;
import com.example.dormmanagement.model.Student;
import com.example.dormmanagement.service.RoomService;
import com.example.dormmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final RoomService roomService;

    public StudentController(StudentService studentService,
                             RoomService roomService) {
        this.studentService = studentService;
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student id " + id + " không tồn tại"));
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student saved = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable String id,
            @RequestBody Student studentDetails
    ) {
        studentDetails.setId(id);
        Student updated = studentService.update(studentDetails)
            .orElseThrow(() -> new ResourceNotFoundException("Student id " + id + " không tồn tại"));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        boolean deleted = studentService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/assign/{roomId}")
    public ResponseEntity<String> assignStudentToRoom(
            @PathVariable String id,
            @PathVariable String roomId
    ) {
        try {
            studentService.assignStudentToRoom(id, roomId);
            return ResponseEntity.ok("Gán sinh viên thành công");
        } catch (ResourceNotFoundException | IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/by-room/{roomId}")
    public ResponseEntity<List<Student>> getStudentsByRoom(@PathVariable String roomId) {
        return ResponseEntity.ok(studentService.getStudentsByRoom(roomId));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterStudents(
            @RequestParam(required = false) String major,
            @RequestParam(required = false) String name
    ) {
        if (major != null && !major.isEmpty()) {
            return ResponseEntity.ok(studentService.filterByMajor(major));
        } else if (name != null && !name.isEmpty()) {
            return ResponseEntity.ok(studentService.filterByName(name));
        } else {
            return ResponseEntity.ok(studentService.findAll());
        }
    }

    @PostMapping("/{id}/checkout")
    public ResponseEntity<String> checkoutStudent(@PathVariable String id) {
        boolean ok = studentService.checkoutStudent(id);
        if (ok) {
            return ResponseEntity.ok("Check-out thành công");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Không tìm thấy Student hoặc lỗi");
    }
}
