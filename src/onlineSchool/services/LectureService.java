package onlineSchool.services;

import onlineSchool.exceptions.ValidationExceptions;
import onlineSchool.models.HomeWork;
import onlineSchool.models.Lecture;
import onlineSchool.repository.LectureRepository;

public class LectureService {
    private int id;
    private LectureRepository lectureRepository;

    public Lecture createNewLecture(String name, String discription, HomeWork[] homeWorks) {
        if (name == null || name.equals("") || name.equals("empty")) {
            try {
                throw new ValidationExceptions("Lecture name can not be empty");
            } catch (ValidationExceptions e) {
                throw new RuntimeException(e);
            }
        }
        if (discription == null || discription.equals("") || discription.equalsIgnoreCase("empty")) {
            try {
                throw new ValidationExceptions("Discription to a Lecture can not be empty");
            } catch (ValidationExceptions e) {
                throw new RuntimeException(e);
            }
        }
        return new Lecture(name, discription, homeWorks);
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
