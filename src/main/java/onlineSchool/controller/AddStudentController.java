package onlineSchool.controller;

import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStudentController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/students")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMsg", "Помилка валідації введених даних");
            return "students";
        }
        try {
            studentsRepository.save(student);
            model.addAttribute("successMsg", "Студента " + student.getStudentName() + " " + student.getStudentLastName() + " успішно додано");
        } catch (Exception e) {
            model.addAttribute("errorMsg", "Помилка при додаванні студента: " + e.getMessage());
        }
        return "students";
    }
}

