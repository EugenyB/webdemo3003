package com.example.webdemo3003.controllers;

import com.example.webdemo3003.dao.TeacherRepository;
import com.example.webdemo3003.entities.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class TeacherController {

    private TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public String showTeachers(Model model) {
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/teacher_subjects")
    public String showSubjectsByTeacher(@RequestParam long id, Model model) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            model.addAttribute("teacher", optionalTeacher.get());
            return "subjects_by_teacher";
        } else {
            return "redirect:/teachers";
        }
    }

    @PostMapping("/add_teacher")
    public String addTeacher(@RequestParam String name, @RequestParam int experience) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setExperience(experience);
        teacherRepository.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/delete_teacher")
    public String deleteTeacher(@RequestParam long id) {
        //TODO Confirmation for delete
        teacherRepository.deleteById(id);
        return "redirect:/teachers";
    }
}
