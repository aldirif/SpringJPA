package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    List<StudentResDto> findAllByName(String lastName, String firstMidName);
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    NewStudentWithCourseResDto insertNewStudentToCourse(NewStudentReqDto newStudentReqDto);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
    StudentWithCourseResDto getStudentWithCourseById(Long id);
    List<StudentWithCourseResDto> getAllStudentWithCourse();
    List<StudentResDto> findStudentWithPagination(int pageNo, int pageSize);
}
