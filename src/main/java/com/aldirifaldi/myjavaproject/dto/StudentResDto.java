package com.aldirifaldi.myjavaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResDto {
    private Long id;
    private String last_name;
    private String first_mid_name;
    private Date enrollment_date;

}
