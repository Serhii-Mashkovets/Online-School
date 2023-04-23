package onlineSchool.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import onlineSchool.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import onlineSchool.repository.StudentsRepository;

import java.util.Set;

@RestController
@RequestMapping("/deleteTheOneStudent")
public class DeleteStudentController {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private Environment env;

    @GetMapping
    public String showDeleteStudentForm() {
        return "deleteTheOneStudent";
    }

    @PostMapping
    public String deleteStudent(@RequestParam("studentId") Integer studentId, Model model) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Student student = new Student();
        student.setId(studentId);
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        if (!violations.isEmpty()) {
            model.addAttribute("errorMessage", "Помилка валідації форми");
            return "deleteTheOneStudent";
        }
        try {
            studentsRepository.deleteById(studentId);
            return "redirect:/getAllStudents";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Помилка видалення студента. Повідомлення про помилку: " + e.getMessage());
            return "deleteTheOneStudent";
        }
    }
}
