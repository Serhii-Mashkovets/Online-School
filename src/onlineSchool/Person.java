package onlineSchool;

public class Person {
    Role roleStudent = Role.STUDENT;
    Role roleTeacher = Role.TEACHER;

    private String role;
    private static int courseId;
    private static int countId;

    public static int getCourseId() {
        return courseId;
    }

    public static int getCountId() {
        return countId;
    }
}
