package onlineSchool.repository;

import onlineSchool.models.Lecture;

import java.util.Scanner;

public class ParentingClassForRepositories {

    private String[] myArray;

    ParentingClassForRepositories[] getAll(ParentingClassForRepositories[] myArray) {
        return myArray;
    }

    public void add(Lecture lecture) {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = String.valueOf(lecture);
        }
    }

    public void getByld(int id) {
        for (int i = 0; i < myArray.length; i++) {
            if (i == id) {
                System.out.println(myArray[i]);
            }
        }

    }

    public void deleteByld(int id) {
        for (int i = 0; i < myArray.length; i++) {
            if (i == id) {
                myArray[i] = null;
            }
        }
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

    public String[] getMyArray() {
        return myArray;
    }

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }
}
