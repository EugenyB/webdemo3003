package com.example.webdemo3003.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "len")
    private Integer len;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "subject_id"))
    private Set<Teacher> teachers = new LinkedHashSet<>();

}