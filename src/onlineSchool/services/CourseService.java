package onlineSchool.services;

import onlineSchool.models.*;

public class CourseService {

    public Course createNewCourse(String courseName, int classroomForLesson,
                                  Lecture lectureName, Person teacherOne, Person StudentOne) {
        if (classroomForLesson <= 0) {
            throw new IllegalArgumentException("classroom for lesson can not be less then 1");
        }
        if (courseName == null || courseName.equals("empty") || courseName.equals(" ")) {
            throw new IllegalArgumentException("Course name can not be empty");
        }
        return new Course(courseName, classroomForLesson, lectureName, teacherOne, StudentOne);
    }
}
