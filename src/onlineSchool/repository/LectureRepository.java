package onlineSchool.repository;

import onlineSchool.models.Lecture;

public class LectureRepository {
    private final int INIT_CAPACITY = 5;
    private Lecture[] lectureArray;

    public LectureRepository() { this.lectureArray = new Lecture[INIT_CAPACITY]; }

    public LectureRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.lectureArray = new Lecture[INIT_CAPACITY];
        } else {
            this.lectureArray = new Lecture[inputCapacity];
        }
    }
}
