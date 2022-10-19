package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    Student updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
    StudentWithCourseResDto getStudentWithCourseById(Long id);
    List<StudentWithCourseResDto> getAllStudentWithCourse();
}
