package com.kupreychik.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kupreychik.dto.request.StudentRequest;
import com.kupreychik.dto.response.ErrorResponse;
import com.kupreychik.dto.response.StudentResponse;
import com.kupreychik.mapper.StudentMapper;
import com.kupreychik.middleware.BirthDateMiddleware;
import com.kupreychik.middleware.Middleware;
import com.kupreychik.middleware.PhoneNumberMiddleware;
import com.kupreychik.model.Student;
import com.kupreychik.repository.StudentRepository;
import com.kupreychik.service.JsonParseService;
import com.kupreychik.service.StudentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final JsonParseService jsonParseService;
    private final StudentMapper studentMapper;

    private final Middleware middleware = Middleware.link(
            new PhoneNumberMiddleware(),
            new BirthDateMiddleware()
    );

    public StudentServiceImpl(StudentRepository studentRepository, JsonParseService jsonParseService, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.jsonParseService = jsonParseService;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponse getStudent(Long id) {
        return null;
    }

    @Override
    public List<StudentResponse> getStudents() {
        log.info("getStudents() method call");
        return studentRepository.getAllStudents()
                .stream()
                .map(studentMapper::mapToResponse)
                .toList();
    }

    @Override
    @SneakyThrows
    public String save(StudentRequest studentRequest) {
        log.info("saveStudent() method call with value {}", studentRequest);

        if (!middleware.check(studentRequest)) {
            return jsonParseService.writeToJson(new ErrorResponse("Cannot create student"));
        }
        Student studentToSave = studentMapper.mapToModel(studentRequest);
        var result = studentRepository.save(studentToSave);
        return jsonParseService.writeToJson(studentMapper.mapToResponse(result));
    }
}
