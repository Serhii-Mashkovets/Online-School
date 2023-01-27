package onlineSchool.services;

import onlineSchool.models.*;
import onlineSchool.exceptions.ValidationExceptions;

public class CourseService {

    public Course createNewCourse(String courseName, int classroomForLesson,
                                  Lecture lectureName, Person teacherOne, Person StudentOne) {
        if (classroomForLesson <= 0) {
            try {
                throw new ValidationExceptions("classroom for lesson can not be less then 1");
            } catch (ValidationExceptions e) {
                throw new RuntimeException(e);
            }
        }
        if (courseName == null || courseName.equals("empty") || courseName.equals(" ")) {
            try {
                throw new ValidationExceptions("Course name can not be empty");
            } catch (ValidationExceptions e) {
                throw new RuntimeException(e);
            }
        }
        return new Course(courseName, classroomForLesson, lectureName, teacherOne, StudentOne);


    }
}
