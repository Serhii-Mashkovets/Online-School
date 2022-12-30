package onlineSchool.repository;

import onlineSchool.models.Course;

public class CourseRepository extends ParentingClassForRepositories {
    private Course[] courses = new Course[0];
    private int lastIndex = -1;
    public Object addCourse(Course course) {
        Course[] newCourses = new Course[3 * courses.length / 2 + 1];
        for (int i = 0; i < courses.length; i++) {
            newCourses[i] = courses[i];
        }
        lastIndex++;
        newCourses[lastIndex] = course;
        this.courses = newCourses;
        return newCourses;
    }
    public Course getCourse(int courseId) {
        for (int i = 0; i <= lastIndex; i++) {
            if (courses[i].getCourseId() == courseId) {
                return courses[i];
            }
        }
        return null;
    }
    public Course[] getAllCourses() {
        return this.courses;
    }

    private static final int INIT_CAPACITY = 5;
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
