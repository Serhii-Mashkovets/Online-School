package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository extends ParentingClassForRepositories{
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

    @Override
    public long size() {
        return personArray.size();
    }

    @Override
    public boolean isEmpty() {
        return personArray.isEmpty();
    }

    @Override
    public Person get(int index) {
        return personArray.get(index);
    }

    public void add(ParentingClassForModels element) {
        personArray.add((Person) element);
    }

    public void add(int index, ParentingClassForModels element) {
        personArray.add(index,(Person) element);
    }

    @Override
    public void remove(int index) {
        personArray.remove(index);
    }
}
