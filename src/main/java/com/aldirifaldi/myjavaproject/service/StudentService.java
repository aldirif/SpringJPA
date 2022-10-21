package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    List<StudentDto> findAllByName(String name);
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    NewStudentWithCourseResDto insertNewStudentToCourse(NewStudentReqDto newStudentReqDto);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
    StudentWithCourseResDto getStudentWithCourseById(Long id);
    List<StudentWithCourseResDto> getAllStudentWithCourse();
    Page<Student> findStudentWithPagination(int offset, int pageSize);
}
