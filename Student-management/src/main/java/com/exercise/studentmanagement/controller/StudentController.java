package com.exercise.studentmanagement.controller;

import com.exercise.studentmanagement.entity.Student;
import com.exercise.studentmanagement.model.ResponseObject;
import com.exercise.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public List<Student> getAllStudent() {
        return studentService.getAllstudentService();
    }

    /**
     * Phương thức truy vấn sinh viên bằng mã id trả ra một đối tượng đã được xử lý bao gồm
     * -Status:Trạng thái tìm thấy sinh viên Ok or Failed
     * -Message:Một thông điệp nào đó được gửi đến client
     * -Data:Đối tượng cần truy vấn rỗng nếu không tìm thấy
     *
     * @param id get request from client is id of student
     * @return an object with : status ,message, data
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findStudentById(@PathVariable Long id) {
        //Dùng kiểu Optional để kiểm soát ngoại lệ là null nếu không tìm thấy
        Optional<Student> foundStudent = studentService.findByIdService(id);
        if (foundStudent.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok", "Query student successfully", foundStudent)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Can't find student with id '" + id + "'", "{}")
            );
        }
    }

    /**
     * @param newStudent
     * @return
     */
    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertStudent(@RequestBody Student newStudent) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Insert Student Successfully", "studentService.")
        );
    }

}
