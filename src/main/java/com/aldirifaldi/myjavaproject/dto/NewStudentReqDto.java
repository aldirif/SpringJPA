package com.aldirifaldi.myjavaproject.dto;

import com.aldirifaldi.myjavaproject.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentReqDto {
    private String lastName;
    private String firstMidName;
    private Long courseId;
    private Grade grade;
}
