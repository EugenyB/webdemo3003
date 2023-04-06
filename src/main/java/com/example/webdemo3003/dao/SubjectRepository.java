package com.example.webdemo3003.dao;

import com.example.webdemo3003.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}