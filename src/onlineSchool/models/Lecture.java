package onlineSchool.models;

import java.util.List;

public class Lecture extends ParentingClassForModels {
    private List<HomeWork> homeWorks;
    private static Integer lectureID;
    private String lectureName;
    private String teacherName;
    private String mainBookToLearning;
    private static int lectureCounter;
    private static int courseLectureId;
    private String description;
    private static int counter = 0;

    public static Integer getId() {
        return lectureID;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public Integer getLectureId() {
        return this.getId();
    }

    public void Lecture(String lectureTopic, String description, String teacherName, Person person, Enum Role,
                        List<HomeWork> homeWorks) {
        this.lectureName = lectureTopic;
        this.teacherName = teacherName;
        this.description = description;
        this.setHomeWorks(homeWorks);
        person.fullPerson("", "");
    }

    @Override
    public String fullPerson(String firstPersoneName, String lastPersonName) {
        return super.fullPerson(firstPersoneName, lastPersonName);
    }

    public Lecture(String lectureName, String discription) {

        this.lectureName = lectureName;
        this.description = discription;
    }

    public Lecture(String lectureTopic, String description, String mainBookToLearning, int courseLectureId,
                   Person person, Enum Role) {
        this.setLectureName(lectureTopic);
        this.description = description;
        this.setMainBookToLearning(mainBookToLearning);
        this.setCourseLectureId(courseLectureId);
        setLectureCounter(getLectureCounter() + 1);
        System.out.println(lectureTopic);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "description='" + description + '\'' +
                ", id=" + getId() +
                ", lectureName='" + lectureName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", mainBookToLearning='" + mainBookToLearning + '\'' +
                ", homework ='" + homeWorks +
                '}';
    }

    public int countId() {
        return this.getCourseLectureId();
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

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<HomeWork> getHomeWorks() {
        return homeWorks;
    }

    public void setHomeWorks(List<HomeWork> homeWorks) {
        this.homeWorks = homeWorks;
    }
}


