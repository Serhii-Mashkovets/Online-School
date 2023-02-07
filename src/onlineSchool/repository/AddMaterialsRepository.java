package onlineSchool.repository;

import onlineSchool.models.AddMaterials;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AddMaterialsRepository extends ParentingClassForRepositories {
    private static AddMaterialsRepository newExample;
    private static Map<Integer, List<AddMaterials>> addMaterials;

    private AddMaterialsRepository() {
        setAddMaterials(new HashMap<>());
    }

    public static AddMaterialsRepository getNewExample() {
        if (newExample == null) {
            newExample = new AddMaterialsRepository();
        }
        return newExample;
    }

    @Override
    public long size() {
        return addMaterials.size();
    }

    @Override
    public boolean isEmpty() {
        return addMaterials.isEmpty();
    }


    public void addNew(int lectureID, List<AddMaterials> addMaterialsArray) {
        getAddMaterials().put(lectureID, addMaterialsArray);
    }

    public void removeNew(int lectureID) {
        addMaterials.remove(lectureID);
    }

    public Map<Integer, List<AddMaterials>> getAllNew() {
        return addMaterials;
    }

    public List<AddMaterials> getNew(int lectureID) {
        return getAddMaterials().get(lectureID);


    }

    public static Map<Integer, List<AddMaterials>> getAddMaterials() {
        return addMaterials;
    }

    public static void setAddMaterials(Map<Integer, List<AddMaterials>> addMaterials) {
        AddMaterialsRepository.addMaterials = addMaterials;
    }

}
