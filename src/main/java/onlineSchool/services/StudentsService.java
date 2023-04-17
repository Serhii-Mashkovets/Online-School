package onlineSchool.services;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Student;

import java.util.Optional;
import java.util.Scanner;

import onlineSchool.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Transactional
@Service
public class StudentsService {

    @Autowired
    private static LoggingRepository logRep;

    private Integer id;

    private StudentsRepository studentsRepository;
    private Scanner scanner;

    public StudentsService() {
        this.studentsRepository = new StudentsRepository();
        this.scanner = new Scanner(System.in);
    }

    public void addStudentFromConsole() {
        try {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student's last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter student's email: ");
            String email = scanner.nextLine();

            Student student = new Student(name, lastName, email);
            studentsRepository.add(student);

            System.out.println("Student added to the database.");
        } catch ( Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }


    public void removeStudentByIdFromConsole() throws EntityNotFoundException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter student ID to remove:");
            int studentId = scanner.nextInt();
            if (!studentsRepository.existsById(studentId)) {
                throw new EntityNotFoundException("Student with id " + studentId + " does not exist");
            }
            studentsRepository.removeById(studentId);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }



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
