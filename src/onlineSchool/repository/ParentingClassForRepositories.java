package onlineSchool.repository;

import onlineSchool.models.ParentingClassForModels;
import onlineSchool.models.School;

import java.util.Arrays;

public class ParentingClassForRepositories {
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


    public void addMySchoolArray(School mySchoolArrays) {
        School[] newMySchoolsArray = new School[(3 * mySchoolArray.length) / 2 + 1];
        for (int i = 0; i < mySchoolArray.length; i++) {
            newMySchoolsArray[i] = mySchoolArray[i];
        }
        mySchoolArrayIndex++;
        newMySchoolsArray[mySchoolArrayIndex] = mySchoolArrays;
        this.mySchoolArray = newMySchoolsArray;
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