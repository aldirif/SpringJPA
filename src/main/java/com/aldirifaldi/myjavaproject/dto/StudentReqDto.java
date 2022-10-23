package com.aldirifaldi.myjavaproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentReqDto {
    private String lastName;
    private String firstMidName;
}
