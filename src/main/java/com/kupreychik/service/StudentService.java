package com.kupreychik.service;

import com.kupreychik.dto.request.StudentRequest;
import com.kupreychik.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse getStudent(Long id);

    List<StudentResponse> getStudents();

    String save(StudentRequest studentRequest);
}
