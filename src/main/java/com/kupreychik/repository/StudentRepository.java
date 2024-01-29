package com.kupreychik.repository;

import com.kupreychik.dto.request.StudentRequest;
import com.kupreychik.exception.ModelNotFound;
import com.kupreychik.mapper.StudentMapper;
import com.kupreychik.model.Student;

import java.util.concurrent.CopyOnWriteArrayList;

public class StudentRepository {

    private final StudentMapper studentMapper;
    private final CopyOnWriteArrayList<Student> students = new CopyOnWriteArrayList<>();

    public StudentRepository(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public Student getStudentByName(String name) throws ModelNotFound {
        return students.stream()
                .filter(el -> name.equals(el.getName()))
                .findFirst()
                .orElseThrow(() -> new ModelNotFound());
    }

    public Student getStudentById(Long id) throws ModelNotFound {
        return students.stream()
                .filter(el -> el.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ModelNotFound());
    }

    public Student addStudent(StudentRequest studentRequest) {
        Student student = studentMapper.mapToModel(studentRequest);
        students.add(student);
        return student;
    }
}
