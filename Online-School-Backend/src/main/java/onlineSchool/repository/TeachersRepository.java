package onlineSchool.repository;

import onlineSchool.models.Teachers;
import onlineSchool.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeachersRepository extends ParentingClassForRepositories {
    private static TeachersRepository newExample;
    private List<Optional<Teachers>> teacherArray;

    public TeachersRepository() {
        teacherArray = new ArrayList<Optional<Teachers>>();
    }

    public static TeachersRepository getNewExample() {
        if (newExample == null) {
            newExample = new TeachersRepository();
        }
        return newExample;
    }


    public List<Optional<Teachers>> usingTeachersByCourseId(int courseId) throws EntityNotFoundException {
        List<Optional<Teachers>> teachersOfCourse = new ArrayList<>();
        for (Optional<Teachers> teacher : teacherArray) {
            if (teacher == null) continue;
            Optional<Teachers> optionalTeacher = teacher.map(t -> t.getCourseId() == courseId ? t : null);
            if (optionalTeacher.isPresent()) teachersOfCourse.add(optionalTeacher);
        }
        if (teachersOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує викладача з таким айді");
        else return teachersOfCourse;
    }


    @Override
    public long size() {
        return teacherArray.size();
    }

    @Override
    public boolean isEmpty() {
        return teacherArray.isEmpty();
    }


    public Optional<Optional<Teachers>> get(int index) {
        return Optional.ofNullable(teacherArray.get(index));
    }

    public void add(Optional<Teachers> element) {
        teacherArray.add(element);
    }

    public void add(int index, Teachers element) {
        teacherArray.add(index, Optional.ofNullable((Teachers) element));
    }

    @Override
    public void remove(int index) {
        teacherArray.remove(index);
    }

    public List<Optional<Teachers>> getTeacherArray() {
        return teacherArray;
    }

    public void setTeacherArray(List<Optional<Teachers>> teacherArray) {
        this.teacherArray = teacherArray;
    }
}
