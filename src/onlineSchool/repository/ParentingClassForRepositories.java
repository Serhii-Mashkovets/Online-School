package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.School;

import java.util.Arrays;

public class ParentingClassForRepositories {
    private static int capacity = 5;
    private static ParentingClassForModels[] pCfRarray = new ParentingClassForModels[capacity];
    private static GeneralizationClass<ParentingClassForModels> parModSrvice = new GeneralizationClass<>(pCfRarray);

    public ParentingClassForModels[] getAllArray() {
        return parModSrvice.getElements();
    }

    public long size() {
        return parModSrvice.size();
    }

    public boolean isEmpty() {
        return parModSrvice.isEmpty();
    }

    public ParentingClassForModels get(int index) {
        return parModSrvice.get(index);
    }

    public void add(ParentingClassForModels pcfmod) {
        if (getAll()[capacity - 1] != null) addMyArray();
        parModSrvice.add(pcfmod);
    }

    public void add(int index, ParentingClassForModels pcfmod) {
        if (getAll()[capacity - 1] != null) addMyArray();
        parModSrvice.add(index, pcfmod);
    }

    public void remove(int index) {
        parModSrvice.remove(index);
    }


    private ParentingClassForModels[] prntNewArr;
    private School[] mySchoolArray = new School[0];
    private int mySchoolArrayIndex = -1;

    public void add(ParentingClassForModels prntMdls, ParentingClassForModels[] prntArr) {
        for (int i = 0; i < prntArr.length; i++) {
            if (prntArr[i] == null) {
                prntArr[i] = prntMdls;
                break;
            }
        }
        prntNewArr = prntArr;
    }

    public ParentingClassForModels[] getAll() {
        return prntNewArr;
    }


    public void addMyArray() {
        capacity = (capacity * 3) / 2 + 1;
        ParentingClassForModels[] parentingArray = new ParentingClassForModels[capacity];
        System.arraycopy(getAll(), 0, parentingArray, 0, capacity);
        parentingArray = getAll();
    }

    public School getMySchoolArray(int schoolId) {
        for (int i = 0; i <= mySchoolArrayIndex; i++) {
            if (mySchoolArray[i].getSchoolId() == schoolId) {
                return mySchoolArray[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ParentingClassForRepositories{" +
                "mySchoolArray=" + Arrays.toString(mySchoolArray) +
                '}';
    }

    public School[] getAllMySchoolsArrays() {
        return this.mySchoolArray;
    }

}