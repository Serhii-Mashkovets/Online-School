package onlineSchool.repository;

import onlineSchool.models.HomeWork;
import onlineSchool.models.Lecture;
import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.loggingJournal.LoggingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HomeWorkRepository extends ParentingClassForRepositories {
    private static final LoggingRepository logRep = new LoggingRepository(AddMaterialsRepository.class.getName());
    private static HomeWorkRepository newExample;
    private static Map<Integer, List<HomeWork>> homeworks;

    public static HomeWorkRepository getNewExample() {
        if (newExample == null) {
            newExample = new HomeWorkRepository();
        }
        return newExample;
    }


    public List<HomeWork> usingHomeWorkWithLectureId(int lectureId) throws EntityNotFoundException {
        List<HomeWork> homeWorksOfLecture = new ArrayList<>();
        for (List<HomeWork> list : homeworks.values()) {
            if (list == null) continue;
            for (HomeWork homework : list) {
                if (homework == null) continue;
                if (homework.getLectureId() == lectureId) homeWorksOfLecture.add(homework);
            }
        }
        if (homeWorksOfLecture.isEmpty()) throw new EntityNotFoundException("Такої домашньої роботи не існує");
        else return homeWorksOfLecture;
    }

    public List<HomeWork> usingHomeWorkWithCourseId(int courseId) throws EntityNotFoundException {
        List<HomeWork> homeworksOfCourse = new ArrayList<>();
        for (Optional<Lecture> lecture : LectureRepository.getNewExample().usingCourseId(courseId)) {
            if (lecture.isEmpty()) continue;
            try {
                List<HomeWork> homeworksOfThisLecture = usingHomeWorkWithLectureId(Lecture.getId());
                homeworksOfCourse.addAll(homeworksOfThisLecture);
            } catch (EntityNotFoundException e) {
                logRep.warningLog("Не існує домашньої роботи з таким айді.", e);
            }
        }
        if (homeworksOfCourse.isEmpty()) throw new EntityNotFoundException("Не існує домашньої роботи з таким айді.");
        else return homeworksOfCourse;
    }


    public static Map<Integer, List<HomeWork>> getHomeworks() {
        return homeworks;
    }

    @Override
    public long size() {
        return getHomeworks().size();
    }

    @Override
    public boolean isEmpty() {
        return getHomeworks().isEmpty();
    }

    public void removeNew(int lectureID) {
        getHomeworks().remove(lectureID);
    }

    public void showAllelementsHomeWorks() {
        if (isEmpty()) System.out.println("""
                Виведемо всі елементи домашнього завдання на екран:
                Жодного елементу не знайдено!
                """);
        for (List<HomeWork> list : homeworks.values()) {
            if (list == null) continue;
            for (HomeWork homeWork : list) {
                if (homeWork == null) continue;
                System.out.println("Виведемо всі елементи домашнього завдання на екран: " + homeworks);
            }
        }
    }

    public HomeWork getNewElement(int ID) {
        for (List<HomeWork> list : homeworks.values()) {
            if (list == null) continue;
            for (HomeWork homeWork : list) {
                if (homeWork == null) continue;
                if (homeWork.getNew() == ID) {
                    System.out.println("Виведемо всі елементи домашнього завдання на екран: " + homeworks);
                    return homeWork;
                }
            }
        }
        return null;
    }

    public List<HomeWork> addNewElements() {
        List<HomeWork> newHomeWork = new ArrayList<>();
        for (List<HomeWork> list : homeworks.values()) {
            if (list == null) continue;
            for (HomeWork homeWork : list) {
                if (homeWork == null) continue;
                newHomeWork.add(homeWork);
            }
        }
        System.out.println("Виведемо всі елементи домашнього завдання на екран: " + newHomeWork);
        return newHomeWork;
    }

    public static void setHomeworks(Map<Integer, List<HomeWork>> homeworks) {
        HomeWorkRepository.homeworks = homeworks;
    }
}
