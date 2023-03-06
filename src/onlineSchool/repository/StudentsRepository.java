package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
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



    public List<Students> usingStudentsByCourseId(int courseId) throws EntityNotFoundException {
        List<Students> studentsOfCourse = new ArrayList<>();
        for (Students student : studentsArray){
            if (student == null) continue;
            if (student.getCourseId() == courseId) studentsOfCourse.add(student);
        }
        if(studentsOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує студента з таким айді");
        else return studentsOfCourse;
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
