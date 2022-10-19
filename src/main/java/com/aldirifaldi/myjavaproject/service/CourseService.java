package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Course;
import com.aldirifaldi.myjavaproject.model.Student;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllSCourse();
    CourseResDto getCourseById(Long id);
    CourseResDto insertCourse(CourseReqDto courseReqDto);
    Course updateCourse(Long id, CourseReqDto courseReqDto);
    void deleteCourse(Long id);
    CourseWithStudentResDto getCourseWithStudentById(Long id);
}
