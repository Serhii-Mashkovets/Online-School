package onlineSchool.controller;


import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentsController {

    @Autowired
    private StudentsRepository studentsRepository;

    @RequestMapping("/getAllStudents")
    public String getStudents(Model model) {
        List<Student> students = (List<Student>) studentsRepository.findAll();
        if (students.isEmpty()) {
            model.addAttribute("errorMessage", "Не знайдено жодного студента");
        } else {
            model.addAttribute("getAllStudents", students);
        }
        return "getAllStudents";
    }
}

