package onlineSchool.models;

public class Lecture {
    public String lessonThemeOne;
    public String lessonThemeTwo;
    public String lessonThemeThree;
    public String lessonThemeFour;
    public String lessonThemeFive;
public static int counter = 0;
    public Lecture() {
        counter++;
    }

   // topic 6
public static int id;
public String lectureTopic;
public String teacherName;
public String mainBookToLearning;
public static int lectureCounter;
public static int courseLectureId;
public Lecture (String lectureTopic, String teacherName, String mainBookToLearning, int courseLectureId) {
    this.lectureTopic = lectureTopic;
    this.teacherName = teacherName;
    this.mainBookToLearning = mainBookToLearning;
    this.courseLectureId = courseLectureId;
    lectureCounter++;
}
public int countId () { return this.courseLectureId;}
}


