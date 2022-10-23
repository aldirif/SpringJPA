package com.aldirifaldi.myjavaproject.repository;

import com.aldirifaldi.myjavaproject.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {

    @Modifying
    @Query(nativeQuery = true, value =
            "Delete from enrollment where student_id =?1 and course_id = ?2")
    void removeStudentFromCourse(Long studentId, Long courseId);

    @Modifying
    @Query(nativeQuery = true, value =
            "Delete from enrollment where course_id = ?1")
    void removeAll(Long courseId);
}
