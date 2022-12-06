package onlineSchool.repository;

import onlineSchool.models.Course;

public class CourseRepository extends SuperPuperRepository{
    private final int INIT_CAPACITY = 5;
    private Course[] courseArray;

    public CourseRepository() {
        this.courseArray = new Course[getINIT_CAPACITY()];
    }

    public CourseRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.courseArray = new Course[getINIT_CAPACITY()];
        } else {
            this.courseArray = new Course[inputCapacity];
        }
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public Course[] getCourseArray() {
        return courseArray;
    }
}
