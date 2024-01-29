package com.kupreychik.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String name;
    private String surname;
    private LocalDateTime birthDate;
    private String phoneNumber;
    private Long groupId;
}
