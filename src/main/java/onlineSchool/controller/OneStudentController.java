package onlineSchool.controller;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import jakarta.validation.constraints.NotNull;

@RestController
public class OneStudentController {

    private final StudentsRepository studentsRepository;

    public OneStudentController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("/getTheOneStudent")
    public String getStudentInfo(@RequestParam("id") @NotNull Integer studentId, Model model) {
        try {
            Optional<Student> student = studentsRepository.findById(studentId);
            if (student.isPresent()) {
                model.addAttribute("student", student.get());
                return "getTheOneStudent";
            } else {
                throw new EntityNotFoundException("Студент з таким id не знайдено");
            }
        } catch (EntityNotFoundException e) {
            model.addAttribute("error", e.getMessage());
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Помилковий формат параметру id");
        } catch (Exception e) {
            model.addAttribute("error", "Помилка при отриманні інформації про студента");
        }
        return "error";
    }
}

