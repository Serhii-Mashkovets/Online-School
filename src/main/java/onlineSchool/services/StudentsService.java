package onlineSchool.services;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Student;

import onlineSchool.repository.StudentsRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Optional;
import java.util.Scanner;

@Service
public class StudentsService {

    private static LoggingRepository logRep = new LoggingRepository(StudentsService.class.getName());

    private Integer id;

    private StudentsRepository studentsRepository;
    private Scanner scanner;

    public StudentsService(StudentsRepository studentsRepository, Scanner scanner) {
        this.studentsRepository = studentsRepository;
        this.scanner = scanner;
    }

    @Transactional
    public void addStudentFromConsole() {
        try {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student's last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter student's email: ");
            String email = scanner.nextLine();

            Student student = new Student(name, lastName, email);
            studentsRepository.save(student);

            System.out.println("Student added to the database.");
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    public void removeStudentByIdFromConsole() throws EntityNotFoundException {
        try {
            System.out.println("Enter student ID to remove:");
            int studentId = scanner.nextInt();
            scanner.nextLine();
            if (!studentsRepository.existsById(studentId)) {
                throw new EntityNotFoundException("Student with id " + studentId + " does not exist");
            }
            studentsRepository.deleteById(studentId);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw e;
        }
    }

    public Student createNewStudent(String studentName, String studentLastName) throws ValidationExceptions {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new ValidationExceptions("Name cannot be empty");
        }
        if (studentLastName == null || studentLastName.trim().isEmpty()) {
            throw new ValidationExceptions("Last name cannot be empty");
        }
        return new Student(studentName, studentLastName);
    }

    public static Optional<Student> createNewStudentByUsers() {

        logRep.debugLog("Creating new student");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student's name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter student's last name:");
        String studentLastName = scanner.nextLine();
        if (studentName.trim().isEmpty() || studentLastName.trim().isEmpty()) {
            return Optional.empty();
        }
        scanner.close();
        return Optional.of(new Student(studentName, studentLastName));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
