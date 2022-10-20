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
                    .grade(enrollment.getGrade())
                    .course_id(enrollment.getCourse().getId())
                    .student_id(enrollment.getStudent().getId()).build());
        }
       return enrollmentDtoList;
    }

    @Override
    public EnrollmentResDto getEnrollmentById(Long id) {
        EnrollmentResDto enrollmentResDto = new EnrollmentResDto();
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(new Enrollment());
        enrollmentResDto.setId(enrollment.getId());
        enrollmentResDto.setGrade(enrollment.getGrade());
        enrollmentResDto.setCourse_id(enrollment.getCourse().getId());
        enrollmentResDto.setStudent_id(enrollment.getStudent().getId());

        return enrollmentResDto;
    }

    @Override
    public EnrollmentResDto insertEnrollment(EnrollmentReqDto enrollmentReqDto) {
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setCourse(
                Course.builder().id(enrollmentReqDto.getCourse_id()).build());
        newEnrollment.setStudent(
                Student.builder().id(enrollmentReqDto.getStudent_id()).build());
        newEnrollment.setGrade(enrollmentReqDto.getGrade());
        Enrollment result = enrollmentRepository.save(newEnrollment);
        return EnrollmentResDto.builder()
                .id(result.getId())
                .grade(result.getGrade())
                .course_id(result.getCourse().getId())
                .student_id(result.getStudent().getId()).build();
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
}
