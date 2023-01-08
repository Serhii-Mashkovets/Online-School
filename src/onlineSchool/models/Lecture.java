package onlineSchool.models;

public class Lecture extends ParentingClassForModels {

    private String description;

    public int getLectureId() {
        return this.id;
    }

    @Override
    public String fullPerson(String firstPersoneName, String lastPersonName) {
        return super.fullPerson(firstPersoneName, lastPersonName);
    }

    public void Lecture(String lectureTopic, String description, String teacherName, Person person, Enum Role) {
        this.lectureName = lectureTopic;
        this.teacherName = teacherName;
        this.description = description;
        person.fullPerson("", "");
    }

    private String lessonThemeOne;
    private String lessonThemeTwo;
    private String lessonThemeThree;
    private String lessonThemeFour;
    private String lessonThemeFive;
    private static int counter = 0;

    @Override
    public String toString() {
        return "Lecture{" +
                "description='" + description + '\'' +
                ", lessonThemeOne='" + lessonThemeOne + '\'' +
                ", lessonThemeTwo='" + lessonThemeTwo + '\'' +
                ", lessonThemeThree='" + lessonThemeThree + '\'' +
                ", lessonThemeFour='" + lessonThemeFour + '\'' +
                ", lessonThemeFive='" + lessonThemeFive + '\'' +
                ", id=" + id +
                ", lectureName='" + lectureName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", mainBookToLearning='" + mainBookToLearning + '\'' +
                '}';
    }

    public Lecture(String name, String discription, HomeWork homeWork) {
        setCounter(getCounter() + 1);
    }

    private int id;
    private String lectureName;
    private String teacherName;
    private String mainBookToLearning;
    private static int lectureCounter;
    private static int courseLectureId;

    public Lecture(String lectureTopic, String description, String mainBookToLearning, int courseLectureId,
                   Person person, Enum Role) {
        this.setLectureName(lectureTopic);
        this.description = description;
        this.setMainBookToLearning(mainBookToLearning);
        this.setCourseLectureId(courseLectureId);
        setLectureCounter(getLectureCounter() + 1);
        System.out.println(lectureTopic);
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


