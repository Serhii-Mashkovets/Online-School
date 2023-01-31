package onlineSchool.repository;

import onlineSchool.models.AddMaterials;
import onlineSchool.models.ParentingClassForModels;

import java.util.ArrayList;
import java.util.List;

public class AddMaterialsRepository extends ParentingClassForRepositories {
    private List<AddMaterials> addMaterialsArray;
    private AddMaterialsRepository () {
        addMaterialsArray = new ArrayList<>();
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

    public List<AddMaterials> getAddMaterialsArray() {
        return addMaterialsArray;
    }

    public void setAddMaterialsArray(List<AddMaterials> addMaterialsArray) {
        this.addMaterialsArray = addMaterialsArray;
    }
}
