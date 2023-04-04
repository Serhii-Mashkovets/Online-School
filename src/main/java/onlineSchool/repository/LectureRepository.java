package onlineSchool.repository;

import onlineSchool.models.Lecture;
import onlineSchool.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class LectureRepository extends ParentingClassForRepositories<Lecture> {
    private static LectureRepository newExample;
    private static List<Optional<Lecture>> lectureArray;


    @Autowired
    public LectureRepository() {
        lectureArray = new ArrayList<Optional<Lecture>>();
    }


    public static LectureRepository getNewExample() {
        if (newExample == null) {
            newExample = new LectureRepository();
        }
        return newExample;
    }

    public static List<Optional<Lecture>> getAll() {
        return lectureArray;
    }


    public List<Optional<Lecture>> usingCourseId(int courseID) throws EntityNotFoundException {
        List<Optional<Lecture>> lecturesOfCourse = new ArrayList<>();
        for (Optional<Lecture> lecture : lectureArray) {
            if (lecture.isEmpty()) continue;
            Optional<Lecture> optionalLecture = lecture.map(l -> l.getCourseLectureId().equals(courseID) ? l : null);
            if (optionalLecture.isPresent()) lecturesOfCourse.add(optionalLecture);
        }
        if (lecturesOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує лекції з даним айді");
        else return lecturesOfCourse;
    }



    public long size() {
        return lectureArray.size();
    }


    public boolean isEmpty() {
        return lectureArray.isEmpty();
    }


    public Optional<Lecture> get(int index) {
        return lectureArray.get(index);
    }

    public void add(Optional<Lecture> element) {
        lectureArray.add(element);
    }


    public void add(int index, Lecture element) {
        lectureArray.add(index, Optional.ofNullable(element));
    }


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
