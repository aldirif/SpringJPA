package com.aldirifaldi.myjavaproject.controller;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/course")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseResDto> getAllCourse(){
        return courseService.getAllSCourse();
    }

    @GetMapping("/ByTitle")
    List<CourseResDto> getCourseByTitle(@RequestParam String title){
        return courseService.findAllByTitle(title);
    }

    @GetMapping("/{id}")
    public CourseResDto getById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResDto insertCourse(@RequestBody CourseReqDto courseReqDto){
        return courseService.insertCourse(courseReqDto);

    }
    @PutMapping("/{id}")
    public CourseResDto put(@PathVariable("id") Long id, @RequestBody CourseReqDto courseReqDto) {
        return courseService.updateCourse(id, courseReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable("id") Long id){
        courseService.deleteCourse(id);
        return "Delete course id: "+id.toString()+" berhasil";
    }

    @GetMapping("/With/student/{id}")
    public CourseWithStudentResDto getCourseWithStudentById(@PathVariable("id") Long id){
        return courseService.getCourseWithStudentById(id);
    }
}