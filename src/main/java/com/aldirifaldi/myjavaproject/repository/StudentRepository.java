package com.aldirifaldi.myjavaproject.repository;

import com.aldirifaldi.myjavaproject.dto.StudentDto;
import com.aldirifaldi.myjavaproject.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findAll(Pageable pageable);

    @Query(nativeQuery = true, value =
            "select s.id, s.first_mid_name as firstMidName, s.last_name as lastName from student s " +
                    "where lower(s.first_mid_name) like lower(concat('%', ?1,'%')) " +
                    "or lower(s.last_name) like lower(concat('%', ?1,'%'))")
    List<StudentDto> searchByName(String keyword);
}
