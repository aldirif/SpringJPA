package com.aldirifaldi.myjavaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class CourseResDto {
    private Long id;
    private String title;
    private Long credits;
}
