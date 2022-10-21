package com.aldirifaldi.myjavaproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentReqDto {
    private String lastName;
    private String firstMidName;
}
