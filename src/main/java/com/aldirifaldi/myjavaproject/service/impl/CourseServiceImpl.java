package com.aldirifaldi.myjavaproject.service.impl;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Course;
import com.aldirifaldi.myjavaproject.model.Enrollment;
import com.aldirifaldi.myjavaproject.repository.CourseRepository;
import com.aldirifaldi.myjavaproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseResDto> getAllSCourse() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        for (Course course : courses){
            courseResDtoList.add(CourseResDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .credits(course.getCredits())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto getCourseById(Long id) {
        CourseResDto courseResDto = new CourseResDto();
        Course course = courseRepository.findById(id).orElse(new Course());
        courseResDto.setId(course.getId());
        courseResDto.setTitle(course.getTitle());
        courseResDto.setCredits(course.getCredits());

        return  courseResDto;
    }

    @Override
    public CourseResDto insertCourse(CourseReqDto courseReqDto) {
        Course newCourse = Course.builder()
                .title(courseReqDto.getTitle())
                .credits(courseReqDto.getCredits()).build();
        Course result = courseRepository.save(newCourse);
        return CourseResDto.builder()
                .id(result.getId())
                .title(result.getTitle())
                .credits(result.getCredits()).build();
    }

    @Override
    public Course updateCourse(Long id, CourseReqDto courseReqDto) {
        Optional<Course> updateCourse = courseRepository.findById(id);
        Course result = new Course();
        if (updateCourse.isPresent()) {
            Course course = updateCourse.get();
            course.setTitle(courseReqDto.getTitle());
            course.setCredits(courseReqDto.getCredits());
            result = courseRepository.save(course);
        }
        return Course.builder()
                .id(result.getId())
                .title(result.getTitle())
                .credits(result.getCredits()).build();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseWithStudentResDto getCourseWithStudentById(Long id) {
        Course course = courseRepository.findById(id).get();
        List<Enrollment> enrollmentList = course.getEnrollments();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for (Enrollment enrollment : enrollmentList){
            studentResDtoList.add(StudentResDto.builder()
                    .id(enrollment.getStudent().getId())
                    .last_name(enrollment.getStudent().getLast_name())
                    .first_mid_name(enrollment.getStudent().getFirst_mid_name())
                    .enrollment_date(enrollment.getStudent().getEnrollment_date()).build());
        }
        return CourseWithStudentResDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .credits(course.getCredits())
                .studentResDtoList(studentResDtoList).build();
    }
}