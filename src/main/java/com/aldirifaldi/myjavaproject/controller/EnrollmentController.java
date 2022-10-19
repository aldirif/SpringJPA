package com.aldirifaldi.myjavaproject.controller;

import com.aldirifaldi.myjavaproject.dto.EnrollmentReqDto;
import com.aldirifaldi.myjavaproject.dto.EnrollmentResDto;
import com.aldirifaldi.myjavaproject.model.Enrollment;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnrollmentResDto insertEnrollment(@RequestBody EnrollmentReqDto enrollmentReqDto){
        return enrollmentService.insertEnrollment(enrollmentReqDto);
    }
    @PutMapping("/{id}")
    public Enrollment put(@PathVariable("id") Long id, @RequestBody EnrollmentReqDto enrollmentReqDto){
        return enrollmentService.updateEnrollment(id, enrollmentReqDto);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable("id") Long id){
        enrollmentService.deleteEnrollment(id);
        return "Delete enrollment id: "+id.toString()+" berhasil";
    }
}
