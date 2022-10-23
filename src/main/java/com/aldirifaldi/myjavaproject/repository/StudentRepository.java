package com.aldirifaldi.myjavaproject.repository;

import com.aldirifaldi.myjavaproject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByLastNameOrFirstMidNameContainingIgnoreCase(String lastName, String firstMidName);
}
