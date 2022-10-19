package com.aldirifaldi.myjavaproject.service.impl;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Enrollment;
import com.aldirifaldi.myjavaproject.model.Student;
import com.aldirifaldi.myjavaproject.repository.StudentRepository;
import com.aldirifaldi.myjavaproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentResDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for (Student student : students) {
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .last_name(student.getLast_name())
                    .first_mid_name(student.getFirst_mid_name())
                    .enrollment_date(student.getEnrollment_date()).build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto getStudentById(Long id) {
        StudentResDto studentResDto = new StudentResDto();
        Student student = studentRepository.findById(id).orElse(new Student());
        studentResDto.setId(student.getId());
        studentResDto.setLast_name(student.getLast_name());
        studentResDto.setFirst_mid_name(student.getFirst_mid_name());
        studentResDto.setEnrollment_date(student.getEnrollment_date());

        return studentResDto;
    }

    @Override
    public StudentResDto insertStudent(StudentReqDto studentReqDto) {
        Student newStudent = Student.builder()
                .last_name(studentReqDto.getLast_name())
                .first_mid_name(studentReqDto.getFirst_mid_name())
                .enrollment_date(studentReqDto.getEnrollment_date()).build();
        Student result = studentRepository.save(newStudent);
        return StudentResDto.builder()
                .id(result.getId())
                .last_name(result.getLast_name())
                .first_mid_name(result.getFirst_mid_name())
                .enrollment_date(result.getEnrollment_date()).build();
    }

    @Override
    public Student updateStudent(Long id, StudentReqDto studentReqDto) {
        Optional<Student> updateStudent = studentRepository.findById(id);
        Student result = new Student();
        if (updateStudent.isPresent()){
            Student student = updateStudent.get();
            student.setLast_name(studentReqDto.getLast_name());
            student.setFirst_mid_name(studentReqDto.getFirst_mid_name());
            student.setEnrollment_date(studentReqDto.getEnrollment_date());
            result = studentRepository.save(student);
        }
        return Student.builder()
                .id(result.getId())
                .last_name(result.getLast_name())
                .first_mid_name(result.getFirst_mid_name())
                .enrollment_date(result.getEnrollment_date()).build();
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentWithCourseResDto getStudentWithCourseById(Long id) {
        Student student = studentRepository.findById(id).get();
        List<Enrollment> enrollmentList = student.getEnrollments();
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        for (Enrollment enrollment : enrollmentList){
            courseResDtoList.add(CourseResDto.builder()
                    .id(enrollment.getCourse().getId())
                    .title(enrollment.getCourse().getTitle())
                    .credits(enrollment.getCourse().getCredits()).build());
        }
        return StudentWithCourseResDto.builder()
                .id(student.getId())
                .last_name(student.getLast_name())
                .first_mid_name(student.getFirst_mid_name())
                .enrollment_date(student.getEnrollment_date())
                .courseResDtoList(courseResDtoList).build();
    }

    @Override
    public List<StudentWithCourseResDto> getAllStudentWithCourse() {
        List<Student> students = studentRepository.findAll();
        List<StudentWithCourseResDto> studentWithCourseResDtoList = new ArrayList<>();
        for (Student student : students){
            List<CourseResDto> courseResDtoList  = new ArrayList<>();
            for(Enrollment enrollment : student.getEnrollments()) {
                courseResDtoList.add(CourseResDto.builder()
                        .id(enrollment.getCourse().getId())
                        .title(enrollment.getCourse().getTitle())
                        .credits(enrollment.getCourse().getCredits()).build());
            }
            studentWithCourseResDtoList.add(
                    StudentWithCourseResDto.builder()
                            .id(student.getId())
                            .last_name(student.getLast_name())
                            .first_mid_name(student.getFirst_mid_name())
                            .enrollment_date(student.getEnrollment_date())
                            .courseResDtoList(courseResDtoList).build()
            );
        }
        return studentWithCourseResDtoList;
    }

}
