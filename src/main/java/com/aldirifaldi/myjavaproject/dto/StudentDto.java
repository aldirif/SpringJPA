package com.aldirifaldi.myjavaproject.dto;

import java.util.Date;

public interface StudentDto {
    Long getId();
    String getLastName();
    String getFirstMidName();
    Date enrollmentDate();
}
