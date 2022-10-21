package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Enrollment;
import com.aldirifaldi.myjavaproject.model.Student;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResDto> getAllEnrollment();
    EnrollmentResDto getEnrollmentById(Long id);
    EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto);
    Enrollment updateEnrollment(Long id, EnrollmentReqDto enrollmentReqDto);
    void deleteEnrollment(Long id);
    void removeStudentFromCourse(Long student_id);
}
