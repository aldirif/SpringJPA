package com.aldirifaldi.myjavaproject.repository;

import com.aldirifaldi.myjavaproject.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
}
