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
            "Remove from enrollment where student_id = ?1")
    void removeStudentFromCourse(Long student_id);

    @Modifying
    @Query(nativeQuery = true, value =
            "Remove from enrollment where student_id =?1 and course_id = ?2")
    void removeAll(Long student_id, Long course_id);

}
