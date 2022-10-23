package com.aldirifaldi.myjavaproject.repository;

import com.aldirifaldi.myjavaproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByTitleContainingIgnoreCase(String title);
}
