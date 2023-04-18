package onlineSchool.services;

import onlineSchool.exceptions.DuplicateEmailException;
import onlineSchool.models.Person;
import onlineSchool.repository.PersonRepository;
import onlineSchool.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    @Test
    public void testCreateNewPersonByUsers() throws DuplicateEmailException {

        PersonRepository personRepository = null;

        List<Person> persons = new ArrayList<>();
        Mockito.when(personRepository.findAll()).thenReturn(persons);
        String input = "John Doe\nDoe\n123456789\njohndoe@example.com\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));


        PersonService personService = new PersonService();
        Optional<Person> result = personService.createNewPersonByUsers();


        Assertions.assertTrue(result.isPresent());
        Person person = result.get();
        Assertions.assertEquals("John", person.getFirstName());
        Assertions.assertEquals("Doe", person.getLastName());
        Assertions.assertEquals("123456789", person.getPhone());
        Assertions.assertEquals("johndoe@example.com", person.getEmail());
    }

    @Test
    public void testCreateNewPersonByUsers_WithDuplicateEmail() {
        PersonRepository personRepository = null;

        List<Person> persons = new ArrayList<>();
        Person person = new Person("Jane", "Doe", "987654321", "janedoe@example.com");
        persons.add(person);
        Mockito.when(personRepository.findAll()).thenReturn(persons);
        String input = "John Doe\nDoe\n123456789\njanedoe@example.com\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        PersonService personService = new PersonService(); // створюємо екземпляр класу

        Assertions.assertThrows(DuplicateEmailException.class, () -> personService.createNewPersonByUsers());
    }

}