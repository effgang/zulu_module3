package com.kupreychik.repository;

import com.kupreychik.exception.ModelNotFound;
import com.kupreychik.model.Student;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StudentRepository {

    private final CopyOnWriteArrayList<Student> students = new CopyOnWriteArrayList<>();

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
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

    public Student save(Student student) {
        student.setId((long) (students.size() + 1));
        students.add(student);
        return student;
    }
}
