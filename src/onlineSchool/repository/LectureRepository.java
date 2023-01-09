package onlineSchool.repository;

import onlineSchool.models.Lecture;


import java.util.Arrays;

public class LectureRepository extends ParentingClassForRepositories {
    private static int size = 5;
    private int number;
    private static Lecture[] lectureArray;

    public LectureRepository() {
        this.lectureArray = new Lecture[size];
    }

    public void add(Lecture lecture) {
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

    public void addLecture(Lecture lecture) {
        Lecture[] newLectures = new Lecture[3 * lectures.length / 2 + 1];
        for (int i = 0; i < lectures.length; i++) {
            newLectures[i] = lectures[i];
        }
        lastIndex++;
        newLectures[lastIndex] = lecture;
        this.lectures = newLectures;
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
