package onlineSchool.repository;

import onlineSchool.models.Lecture;

public class ParentingClassForRepositories {

    private Lecture[] myArray;

    ParentingClassForRepositories[] getAll(ParentingClassForRepositories[] myArray) {
        return myArray;
    }

    public void add(Lecture object) {

    }

    public void getByld() {
        System.out.println(getMyArray()[0]);
    }

    public void deleteByld() {
        getMyArray()[0] = null;
    }

    private int id;

    private int counter;

    public ParentingClassForRepositories(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Lecture[] getMyArray() {
        return myArray;
    }

    public void setMyArray(Lecture[] myArray) {
        this.myArray = myArray;
    }
}
