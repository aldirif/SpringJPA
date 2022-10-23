package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResDto> getAllEnrollment();
    EnrollmentResDto getEnrollmentById(Long id);
    EnrollmentResDto registerStudentToCourse(EnrollmentReqDto enrollmentReqDto);
    EnrollmentResDto updateEnrollment(Long id, EnrollmentReqDto enrollmentReqDto);
    EnrollmentResDto registerGrade(Long id, GradeReqDto gradeReqDto);
    void deleteEnrollment(Long id);
    void removeAllStudentFromCourse(Long courseId);
    void removeStudentFromCourse(StudentWithCourseDto studentWithCourseDto);
}
