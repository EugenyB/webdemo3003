package com.example.webdemo3003.dao;

import com.example.webdemo3003.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameNotNullOrderByName();

    List<Student> findByRatingGreaterThanEqualOrderByRatingDesc(Double rating);

}