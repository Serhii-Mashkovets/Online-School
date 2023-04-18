package onlineSchool.services;

import onlineSchool.exceptions.DuplicateEmailException;
import onlineSchool.loggingJournal.LoggingRepository;

import onlineSchool.models.Person;
import onlineSchool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
public class PersonService {

    @Autowired
    private static LoggingRepository logRep = new LoggingRepository(StudentsService.class.getName());

    PersonRepository personRepository;

    private final ArrayList <Person> persons = new ArrayList<>();

    private int personId;

    @Transactional
    public void isEmailDuplicate(String email) throws DuplicateEmailException {
        List<Person> persons = (List<Person>) personRepository.findAll();

        boolean isDuplicate = persons.stream()
                .map(Person::getEmail)
                .anyMatch(email::equals);

        if (isDuplicate) {
            throw new DuplicateEmailException("Email вже існує: " + email);
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Optional<Person> createNewPersonByUsers() throws DuplicateEmailException {
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

    public Integer getSize() {
        return persons.size();
    }

    public boolean isEmpty() {
        return persons.isEmpty();
    }

    public Person getById(Integer id) {
        return id < persons.size() ? persons.get(id) : null;
    }


    public void add (Person person) {
        persons.add(person);
    }

    public void save (Person person) {
        personRepository.save(person);
    }

    public List<Person> getAll() {
        Iterable<Person> iterable = personRepository.findAll();

        List<Person> list = new ArrayList<>();
        for (Person person : iterable) {
            list.add(person);
        }

        return list;
    }


    public void deleteById(Integer id) {
        personRepository.deleteById(Long.valueOf(id));
    }





    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
