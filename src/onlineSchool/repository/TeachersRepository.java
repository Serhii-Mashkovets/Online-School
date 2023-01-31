package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Teachers;

import java.util.ArrayList;
import java.util.List;

public class TeachersRepository extends ParentingClassForRepositories{
    private List<Teachers> teacherArray;

    public TeachersRepository() {
       teacherArray = new ArrayList<>();
    }

    @Override
    public long size() {
        return teacherArray.size();
    }

    @Override
    public boolean isEmpty() {
        return teacherArray.isEmpty();
    }

    @Override
    public ParentingClassForModels get(int index) {
        return teacherArray.get(index);
    }

    @Override
    public void add(ParentingClassForModels element) {
        teacherArray.add((Teachers) element);
    }

    @Override
    public void add(int index, ParentingClassForModels element) {
        teacherArray.add(index,(Teachers) element);
    }

    @Override
    public void remove(int index) {
        teacherArray.remove(index);
    }

    public List<Teachers> getTeacherArray() {
        return teacherArray;
    }

    public void setTeacherArray(List<Teachers> teacherArray) {
        this.teacherArray = teacherArray;
    }
}
