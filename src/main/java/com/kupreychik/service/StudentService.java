package com.kupreychik.service;

import com.kupreychik.dto.response.StudentResponse;
import com.kupreychik.model.Student;

public interface StudentService {

    StudentResponse getStudent(Long id);
}
