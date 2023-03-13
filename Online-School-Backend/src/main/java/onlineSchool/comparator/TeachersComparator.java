package onlineSchool.comparator;

import onlineSchool.models.Teachers;

import java.util.Comparator;

public class TeachersComparator implements Comparator<Teachers> {
    @Override
    public int compare(Teachers o1, Teachers o2) {
        return o1.getTeacherSecondName().compareToIgnoreCase(o2.getTeacherSecondName());
    }
}
