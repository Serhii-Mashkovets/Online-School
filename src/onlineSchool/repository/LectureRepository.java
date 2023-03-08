package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LectureRepository extends ParentingClassForRepositories<Lecture> {
    private static LectureRepository newExample;
    private static List<Optional<Lecture>> lectureArray;

    public static LectureRepository getNewExample() {
        if (newExample == null) {
            newExample = new LectureRepository();
        }
        return newExample;
    }


    public List<Optional<Lecture>> usingCourseId(int courseID) throws EntityNotFoundException {
        List<Optional<Lecture>> lecturesOfCourse = new ArrayList<>();
        for (Optional<Lecture> lecture : lectureArray) {
            if (lecture == null) continue;
            Optional<Lecture> optionalLecture = lecture.map(l -> l.getCourseLectureId().equals(courseID) ? l : null);
            if (optionalLecture.isPresent()) lecturesOfCourse.add(optionalLecture);
        }
        if (lecturesOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує лекції з даним айді");
        else return lecturesOfCourse;
    }


    public LectureRepository() {
        lectureArray = new ArrayList<Optional<Lecture>>();
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
    public Optional<Lecture> get(int index) {
        return lectureArray.get(index);
    }

    public void add(Optional<Lecture> element) {
        lectureArray.add(element);
    }

    @Override
    public void add(int index, Lecture element) {
        lectureArray.add(index, Optional.ofNullable(element));
    }

    @Override
    public void remove(int index) {
        lectureArray.remove(index);
    }

    public static List<Optional<Lecture>> getLectureArray() {
        return lectureArray;
    }

    public static void setLectureArray(List<Optional<Lecture>> lectureArray) {
        LectureRepository.lectureArray = lectureArray;
    }
}
