package com.aldirifaldi.myjavaproject.controller;

import com.aldirifaldi.myjavaproject.dto.EnrollmentReqDto;
import com.aldirifaldi.myjavaproject.dto.EnrollmentResDto;
import com.aldirifaldi.myjavaproject.dto.StudentWithCourseDto;
import com.aldirifaldi.myjavaproject.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/enrollment")
@RestController
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentResDto> getAllEnrollment() {
        return enrollmentService.getAllEnrollment();
    }

    @GetMapping("/{id}")
    public EnrollmentResDto getById(@PathVariable("id") Long id){
        return enrollmentService.getEnrollmentById(id);
    }

    @PostMapping("/Register")
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResDto insertEnrollment(@RequestBody EnrollmentReqDto enrollmentReqDto){
        return enrollmentService.insertEnrollment(enrollmentReqDto);
    }

    @PutMapping("/{id}")
    public EnrollmentResDto put(@PathVariable("id") Long id, @RequestBody EnrollmentReqDto enrollmentReqDto){
        return enrollmentService.updateEnrollment(id, enrollmentReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable("id") Long id){
        enrollmentService.deleteEnrollment(id);
        return "Delete enrollment id: "+id.toString()+ " berhasil";
    }

    @DeleteMapping("/StudentFromCourse")
    public String removeAll(@RequestBody StudentWithCourseDto studentWithCourseDto){
        enrollmentService.removeStudentFromCourse(studentWithCourseDto);
        return "Delete studentId : " + studentWithCourseDto.getStudentId().toString()
                + " dan courseId : " + studentWithCourseDto.getCourseId().toString() + " berhasil";
    }

    @DeleteMapping("/AllStudentFromCourse/{id}")
    public String removeStudentFromCourse(@PathVariable("id")Long id) {
        enrollmentService.removeAllStudentFromCourse(id);
        return "Delete student dengan courseId : " + id.toString() + " berhasil";
    }
}
