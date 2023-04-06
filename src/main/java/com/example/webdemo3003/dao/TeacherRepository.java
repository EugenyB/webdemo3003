package com.example.webdemo3003.dao;

import com.example.webdemo3003.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}