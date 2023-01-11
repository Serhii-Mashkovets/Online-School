package onlineSchool.repository;

import onlineSchool.models.Lecture;


import java.util.Arrays;

public class LectureRepository extends ParentingClassForRepositories {
    private static int size;
    private int number;
    private static Lecture[] lectureArray = new Lecture[size];

    private static GeneralizationClass<Lecture> lectureGeneralizationService =
            new GeneralizationClass<>(lectureArray);

    @Override
    public long size() {
        return lectureGeneralizationService.size();
    }

    @Override
    public boolean isEmpty() {
        return lectureGeneralizationService.isEmpty();
    }

    @Override
    public void add(Lecture lecture) {
        if (getAll()[size - 1] != null) addLecture();
        lectureGeneralizationService.add(lecture);
    }

    @Override
    public void add(int index, Lecture lecture) {
        if (getAll()[size - 1] != null) {
            addLecture();
        }
        lectureGeneralizationService.add(index, lecture);
    }

    @Override
    public void remove(int index) {
        lectureGeneralizationService.remove(index);
    }

    public LectureRepository() {
        this.lectureArray = new Lecture[size];
    }


    public void addLecture (Lecture lecture) {
        if (lectureArray[lectureArray.length - 1] != null) {
            Lecture[] myArrayTemp = lectureArray;
            lectureArray = new Lecture[lectureArray.length * 3 / 2 + 1];
            System.arraycopy(myArrayTemp, 0, lectureArray, 0, myArrayTemp.length);
            super.add(lecture, lectureArray);
        } else {
            super.add(lecture, lectureArray);
        }
    }

    public Lecture[] getLectures() {
        return (Lecture[]) super.getAll();
    }

    public Lecture[] getByld(int number) {
        return new Lecture[]{lectureArray[number - 1]};
    }

    public void deleteByld(int number) {
        this.number = number;
        lectureArray[number - 1] = null;
    }

    // don`t know what variant is better
    private Lecture[] lectures = new Lecture[0];
    private int lastIndex = -1;

    public void addLecture() {
        size = size * 3 / 2 - 1;
        Lecture[] newLectures = new Lecture[size];
        System.arraycopy(lectureArray, 0, newLectures, 0, size);
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
