package onlineSchool.repository;

import onlineSchool.models.Lecture;
import onlineSchool.models.ParentingClassForModels;


import java.util.Arrays;

public class LectureRepository implements LectureRepoInterface {
    private static int sizeMatter;
    private static Lecture[] lectureArray = new Lecture[sizeMatter];
    private static GeneralizationClass<Lecture> lectureGeneralizationService =
            new GeneralizationClass<>(lectureArray);

    @Override
    public long size() {
        return lectureGeneralizationService.size();
    }

    public Lecture get(int index) {
        return lectureGeneralizationService.get(index);
    }

    public Lecture[] getAll() {
        return lectureGeneralizationService.getElements();
    }

    @Override
    public boolean isEmpty() {
        return lectureGeneralizationService.isEmpty();
    }

    @Override
    public void add(ParentingClassForModels model) {
        if (getAll()[sizeMatter - 1] != null) addLecture();
        lectureGeneralizationService.add((Lecture) model);
    }

    @Override
    public void add(int index, ParentingClassForModels model) {
        if (getAll()[sizeMatter - 1] != null) {
            addLecture();
        }
        lectureGeneralizationService.add(index, (Lecture) model);
    }

    @Override
    public void remove(int index) {
        lectureGeneralizationService.remove(index);
    }

    public LectureRepository() {
        this.lectureArray = new Lecture[sizeMatter];
    }


    public void addLecture(Lecture lecture) {
        if (lectureArray[lectureArray.length - 1] != null) {
            Lecture[] myArrayTemp = lectureArray;
            lectureArray = new Lecture[lectureArray.length * 3 / 2 + 1];
            System.arraycopy(myArrayTemp, 0, lectureArray, 0, myArrayTemp.length);
        }
    }

    public Lecture[] getByld(int number) {
        return new Lecture[]{lectureArray[number - 1]};
    }

    // don`t know what variant is better
    private Lecture[] lectures = new Lecture[0];
    private int lastIndex = -1;

    public void addLecture() {
        sizeMatter = sizeMatter * 3 / 2 - 1;
        Lecture[] newLectures = new Lecture[sizeMatter];
        System.arraycopy(lectureArray, 0, newLectures, 0, sizeMatter);
        lectureGeneralizationService.setElements(newLectures);
    }

    @Override
    public String toString() {
        return "LectureRepository{" +
                "lectures=" + Arrays.toString(lectures) +
                '}';
    }

    public Lecture getLecture(int lectureId) {
        for (int i = 0; i <= lastIndex; i++) {
            if (lectures[i].getLectureId() == lectureId) {
                return lectures[i];
            }
        }
        return null;
    }

    public Lecture[] getAllLectures() {
        return this.lectures;
    }
}
