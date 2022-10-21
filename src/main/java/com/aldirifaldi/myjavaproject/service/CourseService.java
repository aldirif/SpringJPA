package com.aldirifaldi.myjavaproject.service;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Course;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllSCourse();
    List<CourseResDto> findAllByTitle(String title);
    CourseResDto getCourseById(Long id);
    CourseResDto insertCourse(CourseReqDto courseReqDto);
    CourseResDto updateCourse(Long id, CourseReqDto courseReqDto);
    void deleteCourse(Long id);
    CourseWithStudentResDto getCourseWithStudentById(Long id);
}
