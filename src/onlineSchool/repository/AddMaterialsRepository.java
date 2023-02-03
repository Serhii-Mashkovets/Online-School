package onlineSchool.repository;

import onlineSchool.models.AddMaterials;
import onlineSchool.models.ParentingClassForModels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddMaterialsRepository extends ParentingClassForRepositories {
    private static AddMaterialsRepository newExample;
    private List<AddMaterials> addMaterialsArray;
    private AddMaterialsRepository () {
        addMaterialsArray = new ArrayList<>();
    }

    public static AddMaterialsRepository getNewExample () {
        if (newExample == null) {
            newExample = new AddMaterialsRepository();
        } return newExample;
    }


    @Override
    public long size() {
        return getAddMaterialsArray().size();
    }

    @Override
    public boolean isEmpty() {
        return getAddMaterialsArray().isEmpty();
    }

    @Override
    public ParentingClassForModels get(int index) {
        return getAddMaterialsArray().get(index);
    }

    @Override
    public void add(ParentingClassForModels element) {
        getAddMaterialsArray().add((AddMaterials) element);
    }

    @Override
    public void add(int index, ParentingClassForModels element) {
        getAddMaterialsArray().add(index, (AddMaterials) element);
    }

    @Override
    public void remove(int index) {
        getAddMaterialsArray().remove(index);
    }

    public void showAllelementsAddMat () {
        Iterator<AddMaterials> iterator = addMaterialsArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public List getElements() {
        return addMaterialsArray;
    }

    public List<AddMaterials> getAddMaterialsArray() {
        return addMaterialsArray;
    }

    public void setAddMaterialsArray(List<AddMaterials> addMaterialsArray) {
        this.addMaterialsArray = addMaterialsArray;
    }

}
