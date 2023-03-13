package onlineSchool.comparator;

import onlineSchool.models.Students;

import java.util.Comparator;

public class StudentsComparator implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        return o1.getStudentLastName().compareToIgnoreCase(o2.getStudentLastName());
    }
}
