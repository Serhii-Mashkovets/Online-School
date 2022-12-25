package onlineSchool.models;

import onlineSchool.models.Person;

public class Lecture extends ParentingClassForModels {
    private static int personID;

    public void addANewLecture(String lectureTopic, String teacherName, int personID, Person person) {
        this.lectureTopic = lectureTopic;
        this.teacherName = teacherName;
        this.personID = personID;
    }

    private String lessonThemeOne;
    private String lessonThemeTwo;
    private String lessonThemeThree;
    private String lessonThemeFour;
    private String lessonThemeFive;
    private static int counter = 0;

    public Lecture() {
        setCounter(getCounter() + 1);
    }

    private static int id;
    private String lectureTopic;
    private String teacherName;
    private String mainBookToLearning;
    private static int lectureCounter;
    private static int courseLectureId;

    public Lecture(String lectureTopic, String teacherName, String mainBookToLearning, int courseLectureId) {
        this.setLectureTopic(lectureTopic);
        this.setTeacherName(teacherName);
        this.setMainBookToLearning(mainBookToLearning);
        this.setCourseLectureId(courseLectureId);
        setLectureCounter(getLectureCounter() + 1);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Lecture.counter = counter;
    }

    public static int getLectureCounter() {
        return lectureCounter;
    }

    public static void setLectureCounter(int lectureCounter) {
        Lecture.lectureCounter = lectureCounter;
    }

    public static int getCourseLectureId() {
        return courseLectureId;
    }

    public static void setCourseLectureId(int courseLectureId) {
        Lecture.courseLectureId = courseLectureId;
    }

    public static int getPersonID() {
        return personID;
    }

    public static void setPersonID(int personID) {
        Lecture.personID = personID;
    }

    public int countId() {
        return this.getCourseLectureId();
    }

    public String getLessonThemeOne() {
        return lessonThemeOne;
    }

    public void setLessonThemeOne(String lessonThemeOne) {
        this.lessonThemeOne = lessonThemeOne;
    }

    public String getLessonThemeTwo() {
        return lessonThemeTwo;
    }

    public void setLessonThemeTwo(String lessonThemeTwo) {
        this.lessonThemeTwo = lessonThemeTwo;
    }

    public String getLessonThemeThree() {
        return lessonThemeThree;
    }

    public void setLessonThemeThree(String lessonThemeThree) {
        this.lessonThemeThree = lessonThemeThree;
    }

    public String getLessonThemeFour() {
        return lessonThemeFour;
    }

    public void setLessonThemeFour(String lessonThemeFour) {
        this.lessonThemeFour = lessonThemeFour;
    }

    public String getLessonThemeFive() {
        return lessonThemeFive;
    }

    public void setLessonThemeFive(String lessonThemeFive) {
        this.lessonThemeFive = lessonThemeFive;
    }

    public String getLectureTopic() {
        return lectureTopic;
    }

    public void setLectureTopic(String lectureTopic) {
        this.lectureTopic = lectureTopic;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getMainBookToLearning() {
        return mainBookToLearning;
    }

    public void setMainBookToLearning(String mainBookToLearning) {
        this.mainBookToLearning = mainBookToLearning;
    }
}


