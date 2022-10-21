package com.aldirifaldi.myjavaproject.service.impl;

import com.aldirifaldi.myjavaproject.dto.*;
import com.aldirifaldi.myjavaproject.model.Course;
import com.aldirifaldi.myjavaproject.model.Enrollment;
import com.aldirifaldi.myjavaproject.model.Student;
import com.aldirifaldi.myjavaproject.repository.CourseRepository;
import com.aldirifaldi.myjavaproject.repository.EnrollmentRepository;
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

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<StudentResDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for (Student student : students) {
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .lastName(student.getLastName())
                    .firstMidName(student.getFirstMidName())
                    .enrollmentDate(student.getEnrollmentDate()).build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).get();
        return StudentResDto.builder()
                .id(student.getId())
                .firstMidName(student.getFirstMidName())
                .lastName(student.getLastName())
                .enrollmentDate(student.getEnrollmentDate())
                .build();
    }

    @Override
    public StudentResDto insertStudent(StudentReqDto studentReqDto) {
        Student newStudent = Student.builder()
                .lastName(studentReqDto.getLastName())
                .firstMidName(studentReqDto.getFirstMidName()).build();
        Student result = studentRepository.save(newStudent);
        return StudentResDto.builder()
                .id(result.getId())
                .lastName(result.getLastName())
                .firstMidName(result.getFirstMidName())
                .enrollmentDate(result.getEnrollmentDate()).build();
    }

    @Override
    public Student updateStudent(Long id, StudentReqDto studentReqDto) {
        Optional<Student> updateStudent = studentRepository.findById(id);
        Student result = new Student();
        if (updateStudent.isPresent()){
            Student student = updateStudent.get();
            student.setLastName(studentReqDto.getLastName());
            student.setFirstMidName(studentReqDto.getFirstMidName());
            result = studentRepository.save(student);
        }
        return Student.builder()
                .id(result.getId())
                .lastName(result.getLastName())
                .firstMidName(result.getFirstMidName())
                .enrollmentDate(result.getEnrollmentDate()).build();
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
                .lastName(student.getLastName())
                .firstMidName(student.getFirstMidName())
                .enrollmentDate(student.getEnrollmentDate())
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
                            .lastName(student.getLastName())
                            .firstMidName(student.getFirstMidName())
                            .enrollmentDate(student.getEnrollmentDate())
                            .courseResDtoList(courseResDtoList).build()
            );
        }
        return studentWithCourseResDtoList;
    }

}
