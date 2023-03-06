package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Lecture;

import java.util.ArrayList;
import java.util.List;

public class LectureRepository extends ParentingClassForRepositories<Lecture> {
    private static LectureRepository newExample;
    private static List<Lecture> lectureArray;

    public static LectureRepository getNewExample() {
        if (newExample == null) {
            newExample = new LectureRepository();
        }
        return newExample;
    }


    public List<Lecture> usingCourseId(int courseID) throws EntityNotFoundException {
        List<Lecture> lecturesOfCourse = new ArrayList<>();
        for (Lecture lecture : lectureArray) {
            if (lecture == null) continue;
            if (lecture.getCourseLectureId() == courseID) lecturesOfCourse.add(lecture);
        }
        if (lecturesOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує лекції з даним айді");
        else return lecturesOfCourse;
    }


    public LectureRepository() {
        lectureArray = new ArrayList<>();
    }

    @Override
    public long size() {
        return lectureArray.size();
    }

    @Override
    public boolean isEmpty() {
        return lectureArray.isEmpty();
    }

    @Override
    public Lecture get(int index) {
        return lectureArray.get(index);
    }

    @Override
    public void add(Lecture element) {
        lectureArray.add((Lecture) element);
    }

    @Override
    public void add(int index, Lecture element) {
        lectureArray.add(index, (Lecture) element);
    }

    @Override
    public void remove(int index) {
        lectureArray.remove(index);
    }

    public static List<Lecture> getLectureArray() {
        return lectureArray;
    }

    public static void setLectureArray(List<Lecture> lectureArray) {
        LectureRepository.lectureArray = lectureArray;
    }
}
