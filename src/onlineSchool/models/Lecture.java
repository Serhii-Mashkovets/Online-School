package onlineSchool.models;

public class Lecture extends ParentingClassForModels {
    private int id;
    private String lectureName;
    private String teacherName;
    private String mainBookToLearning;
    private static int lectureCounter;
    private static int courseLectureId;
    private String description;
    private static int counter = 0;

    public int getLectureId() {
        return this.id;
    }

    public void Lecture(String lectureTopic, String description, String teacherName, Person person, Enum Role) {
        this.lectureName = lectureTopic;
        this.teacherName = teacherName;
        this.description = description;
        person.fullPerson("", "");
    }

    @Override
    public String fullPerson(String firstPersoneName, String lastPersonName) {
        return super.fullPerson(firstPersoneName, lastPersonName);
    }

    public Lecture(String name, String discription, HomeWork homeWork) {
        setCounter(getCounter() + 1);
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
                ", id=" + id +
                ", lectureName='" + lectureName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", mainBookToLearning='" + mainBookToLearning + '\'' +
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
}


