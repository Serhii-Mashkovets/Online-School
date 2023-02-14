package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.Teachers;

import java.util.ArrayList;
import java.util.List;

public class TeachersRepository extends ParentingClassForRepositories {
    private static TeachersRepository newExample;
    private List<Teachers> teacherArray;

    public TeachersRepository() {
        teacherArray = new ArrayList<>();
    }

    public static TeachersRepository getNewExample() {
        if (newExample == null) {
            newExample = new TeachersRepository();
        }
        return newExample;
    }

    @Override
    public long size() {
        return teacherArray.size();
    }

    @Override
    public boolean isEmpty() {
        return teacherArray.isEmpty();
    }


    public Teachers get(int index) {
        return teacherArray.get(index);
    }

    public void add(Teachers element) {
        teacherArray.add((Teachers) element);
    }

    public void add(int index, Teachers element) {
        teacherArray.add(index, (Teachers) element);
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
