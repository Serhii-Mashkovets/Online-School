package onlineSchool.controller;

import onlineSchool.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deleteTheOneStudent")
public class DeleteStudentController {

    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping
    public String showDeleteStudentForm() {
        return "deleteTheOneStudent";
    }

    @PostMapping
    public String deleteStudent(@RequestParam("studentId") Integer studentId, Model model) {
        try {
            studentsRepository.deleteById(studentId);
            return "redirect:/getAllStudents";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Помилка видалення студента. Повідомлення про помилку: " + e.getMessage());
            return "deleteTheOneStudent";
        }
    }
}

