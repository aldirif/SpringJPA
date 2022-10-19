package com.aldirifaldi.myjavaproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long credits;

    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
    private List<Enrollment> enrollments = new ArrayList<Enrollment>();
}
