package onlineSchool.models;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Lecture extends ParentingClassForModels implements Serializable {
    private LocalDate date;
    @Serial
    private static final long serialazibleNumID = Long.MAX_VALUE;
    private List<HomeWork> homeWorks;
    private static int lectureID;
    private String lectureName;
    private String mainBookToLearning;
    private static int lectureCounter;
    private static Optional<Integer> courseLectureId;
    private String description;
    private static int counter = 0;

    private static LocalDateTime dateTimeLecture;

    private List<AddMaterials> addMaterials;

    private Person person;

    private Teacher teacherOfLecture;

    public Lecture(String lectureTopic, String description,
                   Person person, List<AddMaterials> addMaterials,
                   List<HomeWork> homeWorks) {
        this.lectureName = lectureTopic;
        this.description = description;
        this.setPerson(person);
        this.setHomeWorks(homeWorks);
        this.setAddMaterials(addMaterials);
        this.setDateTimeLecture(LocalDateTime.now());
    }


    public Lecture(String lectureTopic, String description,
                   Teacher teacherOfLecture, List<AddMaterials> addMaterials,
                   List<HomeWork> homeWorks) {
        this.lectureName = lectureTopic;
        this.description = description;
        this.setTeacherOfLecture(teacherOfLecture);
        this.setHomeWorks(homeWorks);
        this.setAddMaterials(addMaterials);
        this.setDateTimeLecture(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "homeWorks=" + homeWorks +
                ", lectureName='" + lectureName + '\'' +
                ", description='" + description + '\'' +
                ", addMaterials=" + addMaterials +
                ", teacherOfLecture=" + teacherOfLecture +
                '}';
    }

    @Override
    public String fullPerson(String firstPersoneName, String lastPersonName) {
        return super.fullPerson(firstPersoneName, lastPersonName);
    }

    public Lecture(String lectureName, String discription) {

        this.lectureName = lectureName;
        this.description = discription;
    }

    public LocalDateTime getCreatedAt() {
        return dateTimeLecture;
    }

    public Optional<Integer> countId() {
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

    public static Optional<Integer> getCourseLectureId() {
        return courseLectureId;
    }

    public static void setCourseLectureId(int courseLectureId) {
        Lecture.courseLectureId = Optional.of(courseLectureId);
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
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

    public static long getSerialazibleNumID() {
        return serialazibleNumID;
    }

    public static int getLectureID() {
        return lectureID;
    }

    public static void setLectureID(int lectureID) {
        Lecture.lectureID = lectureID;
    }

    public static Integer getId() {
        return getLectureID();
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static LocalDateTime getDateTimeLecture(Optional<Lecture> t) {
        return getDateTimeLecture();
    }

    public void setDateTimeLecture(LocalDateTime dateTimeLecture) {
        this.dateTimeLecture = dateTimeLecture;
    }

    @Override
    public int getNew() {
        return 0;
    }

    public Integer getLectureId() {
        return this.getId();
    }


    public List<AddMaterials> getAddMaterials() {
        return addMaterials;
    }

    public void setAddMaterials(List<AddMaterials> addMaterials) {
        this.addMaterials = addMaterials;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static LocalDateTime getDateTimeLecture() {
        return dateTimeLecture;
    }

    public Teacher getTeacherOfLecture() {
        return teacherOfLecture;
    }

    public void setTeacherOfLecture(Teacher teacherOfLecture) {
        this.teacherOfLecture = teacherOfLecture;
    }
}


