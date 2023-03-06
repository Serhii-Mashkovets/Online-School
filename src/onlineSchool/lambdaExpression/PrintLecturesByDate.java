package onlineSchool.lambdaExpression;

import onlineSchool.models.Lecture;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

public class PrintLecturesByDate {

    public void printLecturesByDate(@NotNull List<Lecture> lectures, LocalDate startDate, LocalDate endDate) {

        System.out.println("Лекції починаючи з " + startDate + ":");
        lectures.stream()
                .filter(lecture -> lecture.getDate().isAfter(startDate) || lecture.getDate().isEqual(startDate))
                .forEach(lecture -> System.out.println("- " + lecture.getLectureName()));


        System.out.println("Лекції до " + endDate + ":");
        lectures.stream()
                .filter(lecture -> lecture.getDate().isBefore(endDate) || lecture.getDate().isEqual(endDate))
                .forEach(lecture -> System.out.println("- " + lecture.getLectureName()));


        System.out.println("Лекції між " + startDate + " та " + endDate + ":");
        lectures.stream()
                .filter(lecture -> lecture.getDate().isAfter(startDate) && lecture.getDate().isBefore(endDate))
                .forEach(lecture -> System.out.println("- " + lecture.getLectureName()));
    }

}
