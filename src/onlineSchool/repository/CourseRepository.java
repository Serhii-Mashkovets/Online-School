package onlineSchool.repository;

import onlineSchool.models.Course;

import onlineSchool.models.ParentingClassForModels;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository extends ParentingClassForRepositories {
    private static CourseRepository newExample;

    private static List<Course> courseList;

    public CourseRepository() {
        courseList = new ArrayList<>();
    }

    public static CourseRepository getNewExample() {
        if (newExample == null) {
            newExample = new CourseRepository();
        }
        return newExample;
    }

    @Override
    public long size() {
        return getCourseList().size();
    }

    @Override
    public boolean isEmpty() {
        return getCourseList().isEmpty();
    }

    @Override
    public Course get(int index) {
        return getCourseList().get(index);
    }

    public void add(ParentingClassForModels element) {
        getCourseList().add((Course) element);
    }

    public void add(int index, ParentingClassForModels element) {
        getCourseList().add(index, (Course) element);
    }

    @Override
    public void remove(int index) {
        getCourseList().remove(index);
    }

    @Override
    public List getElements() {
        return courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public static void setCourseList(List<Course> courseList) {
        CourseRepository.courseList = courseList;
    }

}
