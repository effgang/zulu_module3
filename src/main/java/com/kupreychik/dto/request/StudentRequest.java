package com.kupreychik.dto.request;

import com.kupreychik.dto.request.abstracts.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest extends AbstractRequest {
    private String name;
    private String surname;
}
