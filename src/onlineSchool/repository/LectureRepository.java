package onlineSchool.repository;

import onlineSchool.models.Lecture;

public class LectureRepository extends SuperPuperRepository{
    private final int INIT_CAPACITY = 5;
    private Lecture[] lectureArray;

    public LectureRepository() {
        this.lectureArray = new Lecture[getINIT_CAPACITY()];
    }

    public LectureRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.lectureArray = new Lecture[getINIT_CAPACITY()];
        } else {
            this.lectureArray = new Lecture[inputCapacity];
        }
    }

    public void add(Lecture lecture) {
        boolean lastElementIsZero;
        do {
            if (getLectureArray()[getINIT_CAPACITY() - 1] == null) {
                System.out.println("Array is filled");
                lastElementIsZero = true;
            } else {
                lastElementIsZero = false;
                System.out.println("Array is not filled");
            }
        } while (lastElementIsZero != true);
    }

    private void increaseCapacity() {
        int newCapacity = (getINIT_CAPACITY() * 3) / 2 + 1;
        Lecture[] tmp = new Lecture[newCapacity];
        System.arraycopy(getLectureArray(), 0, tmp, 0, getINIT_CAPACITY());
        lectureArray = tmp;
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public Lecture[] getLectureArray() {
        return lectureArray;
    }
}
