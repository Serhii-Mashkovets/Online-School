package onlineSchool.repository;

import onlineSchool.models.Course;

import onlineSchool.models.ParentingClassForModels;

public class CourseRepository implements CourseRepoInterface {
    private Course[] courses = new Course[0];
    private int lastIndex = -1;
    private static final int INIT_CAPACITY = 5;
    private static Course[] courseArray = new Course[INIT_CAPACITY];

    private static GeneralizationClass<Course> courseGeneralizationClass =
            new GeneralizationClass<>(courseArray);

    @Override
    public long size() {
        return courseGeneralizationClass.size();
    }

    @Override
    public boolean isEmpty() {
        return courseGeneralizationClass.isEmpty();
    }

    @Override
    public void add(ParentingClassForModels model) {
        if (getAll()[INIT_CAPACITY - 1] != null) addCourse();
        courseGeneralizationClass.add((Course) model);
    }

    @Override
    public void add(int index, ParentingClassForModels model) {
        if (getAll()[INIT_CAPACITY - 1] != null) addCourse();
        courseGeneralizationClass.add(index, (Course) model);
    }

    @Override
    public void remove(int index) {
        courseGeneralizationClass.remove(index);
    }

    public void addCourse() {
        if (courses[courses.length - 1] != null) {
            Course[] newCourse = new Course[3 * courses.length / 2 + 1];
            System.arraycopy(newCourse, 0, courses, 0, newCourse.length);
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

    public Course[] getAll() {
        return courseGeneralizationClass.getElements();
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
