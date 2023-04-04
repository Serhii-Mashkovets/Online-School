package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Student;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    @Autowired
    private static LoggingRepository logRep;

    private Integer id;

    public Student createNewStudent(String studentName, String studentLastName) {
        if (studentName == null || studentName.equals("") || studentName.equals("empty")) {
            try {
                throw new ValidationExceptions("Name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
            }
        }
        if (studentLastName == null || studentLastName.equals("") ||
                studentLastName.equalsIgnoreCase("empty")) {
            try {
                throw new ValidationExceptions("Second name can not be empty");
            } catch (ValidationExceptions e) {
                System.out.println(String.valueOf(e));
                logRep.warningLog("Помилка валідації: ", e);
            }
        }
        return new Student(studentName, studentLastName);
    }

    @Bean
    public static Optional<Student> createNewStudentByUsers() {
        logRep.debugLog("Створення студента");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("""
                Вкажіть студента кусу
                Введіть ім'я та прізвище""");
        System.out.println("Ім'я ");
        if (sc2.hasNextLine()) {
            String studentName = sc2.next();
            System.out.println("Прізвище: ");
            String studentLastName = sc2.next();
            sc2.close();
            return Optional.of(new Student(studentName, studentLastName));
        }
        return Optional.empty();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
