package com.aldirifaldi.myjavaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseWithStudentResDto {
    private Long id;
    private String title;
    private Long credits;
    List<StudentResDto> studentResDtoList;
}
