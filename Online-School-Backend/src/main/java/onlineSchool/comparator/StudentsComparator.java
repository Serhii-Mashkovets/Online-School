package onlineSchool.comparator;

import onlineSchool.models.Student;

import java.util.Comparator;

public class StudentsComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getStudentLastName().compareToIgnoreCase(o2.getStudentLastName());
    }
}
