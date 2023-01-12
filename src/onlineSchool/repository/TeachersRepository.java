package onlineSchool.repository;

import onlineSchool.models.Teachers;

public class TeachersRepository implements TeachersRepoInterface {
    private static final int INIT_CAPACITY = 5;
    private Teachers[] teacherArray;

    public TeachersRepository() {
        this.teacherArray = new Teachers[getINIT_CAPACITY()];
    }

    public TeachersRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.teacherArray = new Teachers[getINIT_CAPACITY()];
        } else {
            this.teacherArray = new Teachers[inputCapacity];
        }
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public Teachers[] getTeacherArray() {
        return teacherArray;
    }
}
