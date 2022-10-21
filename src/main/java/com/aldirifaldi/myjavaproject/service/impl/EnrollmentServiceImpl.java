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
                    .courseId(enrollment.getCourse().getId())
                    .studentId(enrollment.getStudent().getId()).build());
        }
       return enrollmentDtoList;
    }

    @Override
    public EnrollmentResDto getEnrollmentById(Long id) {
        EnrollmentResDto enrollmentResDto = new EnrollmentResDto();
        Enrollment enrollment = enrollmentRepository.findById(id).orElse(new Enrollment());
        enrollmentResDto.setId(enrollment.getId());
        enrollmentResDto.setGrade(enrollment.getGrade());
        enrollmentResDto.setCourseId(enrollment.getCourse().getId());
        enrollmentResDto.setStudentId(enrollment.getStudent().getId());
        return enrollmentResDto;
    }

    @Override
    public EnrollmentResDto registerStudentToCourse(EnrollmentReqDto enrollmentReqDto) {
        Enrollment newEnrollment = new Enrollment();
        newEnrollment.setCourse(
                Course.builder().id(enrollmentReqDto.getCourseId()).build());
        newEnrollment.setStudent(
                Student.builder().id(enrollmentReqDto.getStudentId()).build());
        newEnrollment.setGrade(enrollmentReqDto.getGrade());
        Enrollment result = enrollmentRepository.save(newEnrollment);
        return  EnrollmentResDto.builder()
                .id(result.getId())
                .grade(result.getGrade())
                .courseId(result.getCourse().getId())
                .studentId(result.getStudent().getId()).build();
    }

    @Override
    public EnrollmentResDto updateEnrollment(Long id, EnrollmentReqDto enrollmentReqDto) {
        Optional<Enrollment> updateEnrollment = enrollmentRepository.findById(id);
        Enrollment result = new Enrollment();
        if(updateEnrollment.isPresent()){
            Enrollment enrollment = updateEnrollment.get();
            enrollment.setStudent(Student.builder()
                    .id(enrollmentReqDto.getStudentId())
                    .build());
            enrollment.setCourse(Course.builder()
                    .id(enrollmentReqDto.getCourseId())
                    .build());
            enrollment.setGrade(enrollmentReqDto.getGrade());
            result = enrollmentRepository.save(enrollment);
        }
        return  EnrollmentResDto.builder()
                .id(result.getId())
                .grade(result.getGrade())
                .courseId(result.getCourse().getId())
                .studentId(result.getStudent().getId()).build();
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public void removeStudentFromCourse(StudentWithCourseDto studentWithCourseDto) {
        enrollmentRepository.removeAll(
                studentWithCourseDto.getStudentId(),
                studentWithCourseDto.getCourseId());
    }

    @Override
    public void removeAllStudentFromCourse(Long courseId) {
        enrollmentRepository.removeStudentFromCourse(courseId);
    }
}
