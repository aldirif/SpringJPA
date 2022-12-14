package com.aldirifaldi.myjavaproject.controller;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResDto> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/ByName")
    public List<StudentResDto> getStudentByName(@RequestParam String lastName, @RequestParam String firstMidName ) {
        return studentService.findAllByName(lastName, firstMidName);
    }

    @GetMapping("/{id}")
    public StudentResDto getById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResDto insertStudent(@RequestBody StudentReqDto studentReqDto){
        return studentService.insertStudent(studentReqDto);
    }

    @PostMapping("/NewStudentToCourse")
    public NewStudentWithCourseResDto insertNewStudentToCourse(@RequestBody NewStudentReqDto newStudentReqDto){
        return studentService.insertNewStudentToCourse(newStudentReqDto);
    }

    @PutMapping("/{id}")
    public StudentResDto put(@PathVariable("id") Long id, @RequestBody StudentReqDto studentReqDto) {
        return studentService.updateStudent(id, studentReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "Delete student id: " + id.toString() + " berhasil";
    }

    @GetMapping("/With/course/{id}")
    public StudentWithCourseResDto getStudentWithCourseById(@PathVariable("id") Long id){
        return studentService.getStudentWithCourseById(id);
    }

    @GetMapping("/WithCourse")
    public List<StudentWithCourseResDto> getAllWithCourse() {
        return studentService.getAllStudentWithCourse();
    }

    @GetMapping("/pagination/{pageNo}/{pageSize}")
    public List<StudentResDto> getPagination(@PathVariable int pageNo, @PathVariable int pageSize){
        return studentService.findStudentWithPagination(pageNo, pageSize);
    }
}
