package com.kupreychik.mapper;

import com.kupreychik.dto.request.StudentRequest;
import com.kupreychik.dto.response.StudentResponse;
import com.kupreychik.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface StudentMapper {

    @Mapping(target = "phone", source = "phoneNumber")
    Student mapToModel(StudentRequest dto);

    @Mapping(target = "groupId", expression = "java(groupId)")
    StudentResponse mapToResponse(Student student, Long groupId);
}
