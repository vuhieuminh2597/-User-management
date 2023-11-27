package com.exercise.studentmanagement.service;

import com.exercise.studentmanagement.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);

}
