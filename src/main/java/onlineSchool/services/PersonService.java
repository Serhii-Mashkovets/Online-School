package onlineSchool.services;

import onlineSchool.exceptions.DuplicateEmailException;
import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Person;
import onlineSchool.repository.PersonRepository;



import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PersonService {


    private static LoggingRepository logRep = new LoggingRepository(StudentsService.class.getName());

    private int personId;


    public static void isEmailDuplicate( String email) throws DuplicateEmailException {
        List<Person> persons = PersonRepository.getAllPersons();

        boolean isDuplicate = persons.stream()
                .map(Person::getEmail)
                .anyMatch(email::equals);

        if (isDuplicate) {
            throw new DuplicateEmailException("Email вже існує: " + email);
        }

    }


    public static Optional<Person> createNewPersonByUsers() throws DuplicateEmailException {
        logRep.debugLog("Створення персони в персон PersonService");
        Scanner sc2 = new Scanner(System.in);
        System.out.println("""
                Вкажіть персону курсу
                Введіть ім'я та прізвище""");
        System.out.println("Ім'я: ");
        if (sc2.hasNextLine()) {
            String personName = sc2.next();
            System.out.println("Прізвище: ");
            String personLastName = sc2.next();
            System.out.println("Введіть телефон: ");
            String personPhone = sc2.next();
            System.out.println("Введіть емейл: ");
            String personEmail = sc2.next();
            System.out.println("Перевіримо емейл на наявність дублікату");
            isEmailDuplicate(personEmail);
            sc2.close();
            return Optional.of(new Person(personName, personLastName, personPhone, personEmail));
        }
        return Optional.empty();
    }


    public static void mapWithEmailAndName(List<Person> persons) {
        Map<String, String> emailToNameMap = persons.stream()
                .collect(Collectors.toMap(Person::getEmail, person -> person.getFirstName() + " " + person.getLastName()));

        emailToNameMap.forEach((email, name) -> System.out.println(email + " -> " + name));
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
