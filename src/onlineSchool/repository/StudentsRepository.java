package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepository extends ParentingClassForRepositories {
    private static List<Students> studentsArray;

    public StudentsRepository() {
        studentsArray = new ArrayList<>();
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
    public ParentingClassForModels get(int index) {
        return studentsArray.get(index);
    }

    @Override
    public void add(ParentingClassForModels element) {
        studentsArray.add((Students) element);
    }

    @Override
    public void add(int index, ParentingClassForModels element) {
        studentsArray.add(index,(Students) element);
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
