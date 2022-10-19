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
public class EnrollmentReqDto {
    private Grade grade;
    private Long course_id;
    private  Long student_id;
}
