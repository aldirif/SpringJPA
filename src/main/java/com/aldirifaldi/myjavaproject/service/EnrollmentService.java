package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Enrollment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResDto> getAllEnrollment();
    EnrollmentResDto getEnrollmentById(Long id);
    EnrollmentResDto registerStudentToCourse(EnrollmentReqDto enrollmentReqDto);
    EnrollmentResDto updateEnrollment(Long id, EnrollmentReqDto enrollmentReqDto);
    void deleteEnrollment(Long id);
    void removeAllStudentFromCourse(Long courseId);
    void removeStudentFromCourse(StudentWithCourseDto studentWithCourseDto);
}
