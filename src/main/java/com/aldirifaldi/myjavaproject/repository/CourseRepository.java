package com.aldirifaldi.myjavaproject.repository;

import com.aldirifaldi.myjavaproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
