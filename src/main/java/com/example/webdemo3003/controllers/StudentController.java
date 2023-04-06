package com.example.webdemo3003.controllers;

import com.example.webdemo3003.dao.StudentRepository;
import com.example.webdemo3003.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findByNameNotNullOrderByName();
//        List<Student> students = studentRepository.findByRatingGreaterThanEqualOrderByRatingDesc(64.0);
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/add_student")
    public String addStudent(@RequestParam String name, @RequestParam int age, @RequestParam double rating) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setRating(rating);
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete_student")
    public String deleteStudent(@RequestParam int id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}
