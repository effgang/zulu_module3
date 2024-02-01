package com.kupreychik.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends AbstractModel {
    private Long id;
    private String name;
    private String surname;
}
