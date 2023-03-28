package onlineSchool.repository;

import onlineSchool.models.Teacher;
import onlineSchool.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeachersRepository extends ParentingClassForRepositories {
    private static TeachersRepository newExample;
    private List<Optional<Teacher>> teacherArray;

    public TeachersRepository() {
        teacherArray = new ArrayList<Optional<Teacher>>();
    }

    public static TeachersRepository getNewExample() {
        if (newExample == null) {
            newExample = new TeachersRepository();
        }
        return newExample;
    }


    public List<Optional<Teacher>> usingTeachersByCourseId(int courseId) throws EntityNotFoundException {
        List<Optional<Teacher>> teachersOfCourse = new ArrayList<>();
        for (Optional<Teacher> teacher : teacherArray) {
            if (teacher.isEmpty()) continue;
            Optional<Teacher> optionalTeacher = teacher.map(t -> t.getCourseId() == courseId ? t : null);
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


    public Optional<Optional<Teacher>> get(int index) {
        return Optional.ofNullable(teacherArray.get(index));
    }

    public void add(Optional<Teacher> element) {
        teacherArray.add(element);
    }

    public void add(int index, Teacher element) {
        teacherArray.add(index, Optional.ofNullable((Teacher) element));
    }

    @Override
    public void remove(int index) {
        teacherArray.remove(index);
    }

    public List<Optional<Teacher>> getTeacherArray() {
        return teacherArray;
    }

    public void setTeacherArray(List<Optional<Teacher>> teacherArray) {
        this.teacherArray = teacherArray;
    }
}
