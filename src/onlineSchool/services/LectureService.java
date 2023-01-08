package onlineSchool.services;

import onlineSchool.models.HomeWork;
import onlineSchool.models.Lecture;
import onlineSchool.repository.LectureRepository;

public class LectureService {

    public Lecture createNewLecture(String name, String discription, HomeWork homeWork) {
        if (name == null || name.equals("") || name.equals("empty")) {
            throw new NullPointerException("Lecture name can not be empty");
        }
        if (discription == null || discription.equals("") || discription.equalsIgnoreCase("empty")) {
            throw new NullPointerException("Discription to a Lecture can not be empty");
        }
        return new Lecture(name, discription, homeWork);
    }

    private LectureRepository lectureRepository;

    public LectureService() {
    }

    public void printLectureIds() {
        Lecture[] lectures;
        lectures = lectureRepository.getAllLectures();

        for (int i = 0; i < lectures.length; i++) {
            Lecture lecture = lectures[i];
            if (lecture == null) {
                break;
            }

            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(lecture.getLectureId());
        }
    }

    private int id;
}
