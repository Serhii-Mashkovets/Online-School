package onlineSchool.repository;

import onlineSchool.models.Course;
import onlineSchool.models.Lecture;

public class CourseRepository extends ParentingClassForRepositories {
    private Course[] courses = new Course[0];
    private int lastIndex = -1;
    private static final int INIT_CAPACITY = 5;
    private Course[] courseArray;

    public void addCourse(Course course) {
        if (courses[courses.length - 1] != null) {
            Course[] newCourse = courses;
            newCourse = new Course[3 * courses.length / 2 + 1];
            System.arraycopy(newCourse, 0, courses, 0, newCourse.length);
            super.add(course, courses);
        } else {
            super.add(course, courses);
        }
    }

    public Course getCourse(int courseId) {
        for (int i = 0; i <= lastIndex; i++) {
            if (courses[i].getCourseId() == courseId) {
                return courses[i];
            }
        }
        return null;
    }

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

    public Course[] getAllCourses() {
        return this.courses;
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public Course[] getCourseArray() {
        return courseArray;
    }
}
