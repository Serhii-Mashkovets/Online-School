package onlineSchool.repository;

import onlineSchool.models.Course;

public class CourseRepository {
    private final int INIT_CAPACITY = 5;
    private Course[] courseArray;

    public CourseRepository() {
        this.courseArray = new Course[INIT_CAPACITY];
    }

    public CourseRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.courseArray = new Course[INIT_CAPACITY];
        } else {
            this.courseArray = new Course[inputCapacity];
        }
    }
}
