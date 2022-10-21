package com.aldirifaldi.myjavaproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewStudentWithCourseResDto {
    private Long id;
    private String lastName;
    private String firstMidName;
    @JsonFormat(timezone = "GMT+07:00")
    private Date enrollmentDate;
    private CourseResDto courseResDto;
}
