package onlineSchool.repository;

import onlineSchool.models.Students;

public class StudentsRepository {
    private final int INIT_CAPACITY = 5;
    private Students[] studentsArray;

    public StudentsRepository() {
        this.studentsArray = new Students[INIT_CAPACITY];
    }

    public StudentsRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.studentsArray = new Students[INIT_CAPACITY];
        } else {
            this.studentsArray = new Students[inputCapacity];
        }
    }
}
