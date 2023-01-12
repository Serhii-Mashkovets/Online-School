package onlineSchool.repository;

import onlineSchool.models.HomeWork;
import onlineSchool.models.Lecture;
import onlineSchool.models.ParentingClassForModels;

public class HomeWorkRepository implements HomeWorkRepoInterface {
    private static final int INIT_CAPACITY = 5;
    private static HomeWork[] homeWOrkArray = new HomeWork [INIT_CAPACITY];

    private static GeneralizationClass<HomeWork> HomeWorkGeneralizationService =
            new GeneralizationClass<>(homeWOrkArray);


    @Override
    public HomeWork[] getAll() {
        return HomeWorkGeneralizationService.getElements();
    }

    @Override
    public long size() {
        return HomeWorkGeneralizationService.size();
    }
    public boolean isEmpty () {
        return HomeWorkGeneralizationService.isEmpty();
    }

    @Override
    public void add(ParentingClassForModels model) {
        if (getAll()[INIT_CAPACITY - 1] != null) addHomeWork();
       HomeWorkGeneralizationService.add((HomeWork) model);
    }

    @Override
    public void add(int index, ParentingClassForModels model) {
        if (getAll()[INIT_CAPACITY - 1] != null) {
            addHomeWork();
        }
        HomeWorkGeneralizationService.add(index, (HomeWork) model);
    }

    @Override
    public void remove(int index) {
HomeWorkGeneralizationService.remove(index);
    }

    public void addHomeWork () {
        if (homeWOrkArray[homeWOrkArray.length - 1] != null) {
            HomeWork[] myArrayTemp = homeWOrkArray;
            homeWOrkArray = new HomeWork[homeWOrkArray.length * 3 / 2 + 1];
            System.arraycopy(myArrayTemp, 0, homeWOrkArray, 0, myArrayTemp.length);
        }
    }

    public HomeWorkRepository() {
        this.homeWOrkArray = new HomeWork[getINIT_CAPACITY()];
    }

    public HomeWorkRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.homeWOrkArray = new HomeWork[getINIT_CAPACITY()];
        } else {
            this.homeWOrkArray = new HomeWork[inputCapacity];
        }
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public HomeWork[] getHomeWOrkArray() {
        return homeWOrkArray;
    }
}
