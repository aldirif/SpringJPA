package com.aldirifaldi.myjavaproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRes<T> {
    int recordCount;
    T response;
}
