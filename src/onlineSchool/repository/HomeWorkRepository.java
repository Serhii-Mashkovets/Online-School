package onlineSchool.repository;

import onlineSchool.models.HomeWork;

public class HomeWorkRepository {
    private final int INIT_CAPACITY = 5;
    private HomeWork[] homeWOrkArray;

    public HomeWorkRepository() {
        this.homeWOrkArray = new HomeWork[INIT_CAPACITY];
    }

    public HomeWorkRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.homeWOrkArray = new HomeWork[INIT_CAPACITY];
        } else {
            this.homeWOrkArray = new HomeWork[inputCapacity];
        }
    }
}
