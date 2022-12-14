package onlineSchool.repository;

import onlineSchool.models.Students;

public class StudentsRepository extends ParentingClassForRepositories {
    private static final int INIT_CAPACITY = 5;
    private Students[] studentsArray;

    public StudentsRepository() {
        super(1);
        this.studentsArray = new Students[getINIT_CAPACITY()];
    }

    public StudentsRepository(int inputCapacity) {
        super(1);
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.studentsArray = new Students[getINIT_CAPACITY()];
        } else {
            this.studentsArray = new Students[inputCapacity];
        }
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public Students[] getStudentsArray() {
        return studentsArray;
    }
}
