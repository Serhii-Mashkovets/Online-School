package onlineSchool.repository;

import onlineSchool.models.HomeWork;
import onlineSchool.models.ParentingClassForModels;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkRepository extends ParentingClassForRepositories {
    private static HomeWorkRepository newExample;
    private static List<HomeWork> homeWOrkArray;

    public static HomeWorkRepository getNewExample() {
        if (newExample == null) {
            newExample = new HomeWorkRepository();
        }
        return newExample;
    }

    public HomeWorkRepository() {
        setHomeWOrkArray(new ArrayList<>());
    }

    @Override
    public long size() {
        return getHomeWOrkArray().size();
    }

    @Override
    public boolean isEmpty() {
        return getHomeWOrkArray().isEmpty();
    }

    @Override
    public ParentingClassForModels get(int index) {
        return getHomeWOrkArray().get(index);
    }

    @Override
    public void add(ParentingClassForModels element) {
        getHomeWOrkArray().add((HomeWork) element);
    }

    @Override
    public void add(int index, ParentingClassForModels element) {
        getHomeWOrkArray().add(index, (HomeWork) element);
    }

    @Override
    public void remove(int index) {
        getHomeWOrkArray().remove(index);
    }

    public static List<HomeWork> getHomeWOrkArray() {
        return homeWOrkArray;
    }

    public static void setHomeWOrkArray(List<HomeWork> homeWOrkArray) {
        HomeWorkRepository.homeWOrkArray = homeWOrkArray;
    }
}
