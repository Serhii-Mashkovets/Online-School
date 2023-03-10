package onlineSchool.repository;

import onlineSchool.models.Lecture;
import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository extends ParentingClassForRepositories {
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

    public void add(ParentingClassForModels element) {
        personArray.add((Person) element);
    }

    public void add(int index, ParentingClassForModels element) {
        personArray.add(index, (Person) element);
    }

    @Override
    public void remove(int index) {
        personArray.remove(index);
    }
}
