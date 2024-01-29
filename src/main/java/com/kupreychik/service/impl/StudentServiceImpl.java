package com.kupreychik.service.impl;

import com.kupreychik.dto.response.StudentResponse;
import com.kupreychik.mapper.StudentMapper;
import com.kupreychik.model.Student;
import com.kupreychik.repository.StudentRepository;
import com.kupreychik.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponse getStudent(Long id) {
        return null;
    }
}
