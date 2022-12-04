package onlineSchool.repository;

import onlineSchool.models.Teachers;

public class TeachersRepository {
    private final int INIT_CAPACITY = 5;
    private Teachers[] teacherArray;

    public TeachersRepository() {
        this.teacherArray = new Teachers[INIT_CAPACITY];
    }

    public TeachersRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.teacherArray = new Teachers[INIT_CAPACITY];
        } else {
            this.teacherArray = new Teachers[inputCapacity];
        }
    }
}
