package onlineSchool.repository;

import onlineSchool.models.Lecture;
import onlineSchool.models.ParentingClassForModels;

import java.util.ArrayList;
import java.util.List;

public class LectureRepository extends ParentingClassForRepositories {
    private static LectureRepository newExample;
    private static List<Lecture> lectureArray;

    public static LectureRepository getNewExample() {
        if (newExample == null) {
            newExample = new LectureRepository();
        }
        return newExample;
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
    public ParentingClassForModels get(int index) {
        return lectureArray.get(index);
    }

    @Override
    public void add(ParentingClassForModels element) {
        lectureArray.add((Lecture) element);
    }

    @Override
    public void add(int index, ParentingClassForModels element) {
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
