package onlineSchool.repository;

import onlineSchool.models.HomeWork;

public class HomeWorkRepository extends SuperPuperRepository{
    private final int INIT_CAPACITY = 5;
    private HomeWork[] homeWOrkArray;

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
