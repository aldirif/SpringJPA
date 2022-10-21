package com.aldirifaldi.myjavaproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithCourseResDto {
    private Long id;
    private String lastName;
    private String firstMidName;
    @JsonFormat(timezone = "GMT+07:00") // Agar ditampilkan +7, bukan UTC
    private Date enrollmentDate;
    List<CourseResDto> courseResDtoList;
}
