package onlineSchool.repository;

import onlineSchool.models.Lecture;

public class ParentingClassForRepositories {

    private String[] myArray;

    private int arrayLength;

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
        arrayLength = myArray.length;
        for (int i = 0; i < myArray.length; i++) {
            if (i == id) {
                int num = Integer.parseInt(myArray[i]);
                num = arrayLength - 1;
                arrayLength = arrayLength - 2;
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

    public int getArrayLength() {
        return arrayLength;
    }

    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }
}
