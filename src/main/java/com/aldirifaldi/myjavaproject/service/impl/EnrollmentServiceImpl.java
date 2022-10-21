package com.aldirifaldi.myjavaproject.service.impl;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Course;
import com.aldirifaldi.myjavaproject.model.Enrollment;
import com.aldirifaldi.myjavaproject.model.Student;
import com.aldirifaldi.myjavaproject.repository.EnrollmentRepository;
import com.aldirifaldi.myjavaproject.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<EnrollmentResDto> getAllEnrollment() {
        List<EnrollmentResDto> enrollmentDtoList = new ArrayList<>();
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        for (Enrollment enrollment : enrollments){
            enrollmentDtoList.add(EnrollmentResDto.builder()
                    .id(enrollment.getId())
                    .grade(enrollment.getGrade()).build());
        }
       return enrollmentDtoList;
    }

    @Override
    public EnrollmentResDto getEnrollmentById(Long id) {
        EnrollmentResDto enrollmentResDto = new EnrollmentResDto();
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(new Enrollment());
        enrollmentResDto.setId(enrollment.getId());
        enrollmentResDto.setGrade(enrollment.getGrade());

        return enrollmentResDto;
    }

    @Override
    public EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto) {
        return null;
    }


    @Override
    public Enrollment updateEnrollment(Long id, EnrollmentReqDto enrollmentReqDto) {
        Optional<Enrollment> updateEnrollment = enrollmentRepository.findById(id);
        Enrollment result = new Enrollment();
        if(updateEnrollment.isPresent()){
            Enrollment enrollment = updateEnrollment.get();
            enrollment.setGrade(enrollmentReqDto.getGrade());
            result = enrollmentRepository.save(enrollment);
        }
        return  Enrollment.builder()
                .id(result.getId())
                .grade(result.getGrade()).build();
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);

    }

    @Override
    public void removeStudentFromCourse(Long student_id) {
        enrollmentRepository.removeStudentFromCourse(student_id);
    }
}
