package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResDto> getAllEnrollment();
    EnrollmentResDto getEnrollmentById(Long id);
    EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto);
    EnrollmentResDto updateEnrollment(Long id, EnrollmentReqDto enrollmentReqDto);
    void deleteEnrollment(Long id);
    void removeAllStudentFromCourse(Long courseId);
    void removeStudentFromCourse(StudentWithCourseDto studentWithCourseDto);
}
