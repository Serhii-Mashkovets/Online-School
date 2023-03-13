package onlineSchool.repository;

import onlineSchool.models.Students;
import onlineSchool.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentsRepository extends ParentingClassForRepositories {
    private static StudentsRepository newExample;
    private static List<Optional<Students>> studentsArray;

    public StudentsRepository() {
        studentsArray = new ArrayList<Optional<Students>>();
    }

    public static StudentsRepository getNewExample() {
        if (newExample == null) {
            newExample = new StudentsRepository();
        }
        return newExample;
    }


    public List<Optional<Students>> usingStudentsByCourseId(int courseId) throws EntityNotFoundException {
        List<Optional<Students>> studentsOfCourse = new ArrayList<>();
        for (Optional<Students> student : studentsArray) {
            if (student == null) continue;
            Optional<Students> optionalStudent = student.map(s -> s.getCourseId().equals(courseId) ? s : null);
            if (optionalStudent.isPresent()) studentsOfCourse.add(optionalStudent);
        }
        if (studentsOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує студента з таким айді");
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
    public Optional<Optional<Students>> get(int index) {
        return Optional.ofNullable(studentsArray.get(index));
    }

    public void add(Optional<Students> element) {
        studentsArray.add(element);
    }

    public void add(int index, Students element) {
        studentsArray.add(index, Optional.ofNullable((Students) element));
    }

    @Override
    public void remove(int index) {
        studentsArray.remove(index);
    }

    public static List<Optional<Students>> getStudentsArray() {
        return studentsArray;
    }

    public static void setStudentsArray(List<Optional<Students>> studentsArray) {
        StudentsRepository.studentsArray = studentsArray;
    }
}
