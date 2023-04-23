package onlineSchool.controller;

import jakarta.validation.*;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;
import onlineSchool.validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private Environment env;

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

    @PostMapping("/addStudent")
    public String addStudent(@Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", "Помилка валідації форми");
            return "addStudent";
        }
        studentsRepository.save(student);
        model.addAttribute("successMessage", "Студент успішно доданий");
        return "addStudent";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        binder.addValidators((org.springframework.validation.Validator) new StudentValidator(validator, env));
    }
}
