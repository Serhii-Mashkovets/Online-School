package onlineSchool.comparator;

import onlineSchool.models.Teacher;

import java.util.Comparator;

public class TeachersComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getTeacherSecondName().compareToIgnoreCase(o2.getTeacherSecondName());
    }
}
