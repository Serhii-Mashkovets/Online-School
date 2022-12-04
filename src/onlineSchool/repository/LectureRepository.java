package onlineSchool.repository;

import onlineSchool.models.Lecture;

public class LectureRepository {
    private final int INIT_CAPACITY = 5;
    private Lecture[] lectureArray;

    public LectureRepository() {
        this.lectureArray = new Lecture[INIT_CAPACITY];
    }

    public LectureRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.lectureArray = new Lecture[INIT_CAPACITY];
        } else {
            this.lectureArray = new Lecture[inputCapacity];
        }
    }

    public void add(Lecture lecture) {
        boolean lastElementIsZero;
        do {
            if (lectureArray[INIT_CAPACITY - 1] == null) {
                System.out.println("Array is filled");
                lastElementIsZero = true;
            } else {
                lastElementIsZero = false;
                System.out.println("Array is not filled");
            }
        } while (lastElementIsZero != true);
    }

    private void increaseCapacity() {
        int newCapacity = (INIT_CAPACITY * 3) / 2 + 1;
        Lecture[] tmp = new Lecture[newCapacity];
        System.arraycopy(lectureArray, 0, tmp, 0, INIT_CAPACITY);
        lectureArray = tmp;
    }
}
