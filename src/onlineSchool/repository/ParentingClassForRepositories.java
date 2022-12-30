package onlineSchool.repository;

import onlineSchool.models.School;

public class ParentingClassForRepositories {
    private School[] mySchoolArray = new School[0];
    private int mySchoolArrayIndex = -1;

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

    public School[] getAllMySchoolsArrays() {
        return this.mySchoolArray;
    }
}