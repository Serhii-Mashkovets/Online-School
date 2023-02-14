package onlineSchool.repository;

import onlineSchool.models.AddMaterials;
import onlineSchool.models.HomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeWorkRepository extends ParentingClassForRepositories {
    private static HomeWorkRepository newExample;
    private static Map<Integer, List<HomeWork>> homeworks;

    public static HomeWorkRepository getNewExample() {
        if (newExample == null) {
            newExample = new HomeWorkRepository();
        }
        return newExample;
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
