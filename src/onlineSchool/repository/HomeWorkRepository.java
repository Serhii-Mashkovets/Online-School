package onlineSchool.repository;

import onlineSchool.models.HomeWork;

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

    public void addNew(int lectureID, List<HomeWork> homeWOrkArray) {
        getHomeworks().put(lectureID, homeWOrkArray);
    }

    public void removeNew(int lectureID) {
        getHomeworks().remove(lectureID);
    }

    public Map<Integer, List<HomeWork>> getAllNew() {
        return getHomeworks();
    }

    public List<HomeWork> getNew(int lectureID) {
        return getHomeworks().get(lectureID);
    }

    public static void setHomeworks(Map<Integer, List<HomeWork>> homeworks) {
        HomeWorkRepository.homeworks = homeworks;
    }
}
