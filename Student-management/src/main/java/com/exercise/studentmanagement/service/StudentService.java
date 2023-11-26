package com.exercise.studentmanagement.service;

import com.exercise.studentmanagement.entity.Student;
import com.exercise.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllstudentService() {
        return studentRepository.findAll();
    }

    public Optional<Student> findByIdService(Long id) {
        return studentRepository.findById(id);
    }

}
