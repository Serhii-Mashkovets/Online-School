package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepository extends ParentingClassForRepositories {
    private static StudentsRepository newExample;
    private static List<Students> studentsArray;

    public StudentsRepository() {
        studentsArray = new ArrayList<>();
    }

    public static StudentsRepository getNewExample() {
        if (newExample == null) {
            newExample = new StudentsRepository();
        }
        return newExample;
    }

    @Override
    public long size() {
        return studentsArray.size();
    }

    @Override
    public boolean isEmpty() {
        return studentsArray.isEmpty();
    }

    @Override
    public Students get(int index) {
        return studentsArray.get(index);
    }

    public void add(Students element) {
        studentsArray.add((Students) element);
    }

    public void add(int index, Students element) {
        studentsArray.add(index, (Students) element);
    }

    @Override
    public void remove(int index) {
        studentsArray.remove(index);
    }

    public static List<Students> getStudentsArray() {
        return studentsArray;
    }

    public static void setStudentsArray(List<Students> studentsArray) {
        StudentsRepository.studentsArray = studentsArray;
    }
}
