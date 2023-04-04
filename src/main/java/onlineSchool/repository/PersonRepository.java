package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository extends ParentingClassForRepositories<Person> {
    private static PersonRepository newExample;
    private static List<Person> personArray;

    public static PersonRepository getNewExample() {
        if (newExample == null) {
            newExample = new PersonRepository();
        }
        return newExample;
    }

    public PersonRepository() {
        personArray = new ArrayList<>();
    }

    public static List<Person> getAllPersons() {
        return  personArray;
    }

    @Override
    public long size() {
        return personArray.size();
    }

    @Override
    public boolean isEmpty() {
        return personArray.isEmpty();
    }

    @Override
    public Optional<Person> get(int index) {
        return Optional.ofNullable(personArray.get(index));
    }

    @Override
    public void add(Person element) {
        personArray.add(element);
    }

    @Override
    public void add(int index, Person element) {
        personArray.add(index, element);
    }

    @Override
    public void remove(int index) {
        personArray.remove(index);
    }
}
