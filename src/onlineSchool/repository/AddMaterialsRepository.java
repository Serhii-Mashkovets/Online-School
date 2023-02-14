package onlineSchool.repository;

import onlineSchool.comparator.AddMaterialsComparator;
import onlineSchool.models.AddMaterials;

import java.util.*;


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

    public List<AddMaterials> getNew(int lectureID) {
        return getAddMaterials().get(lectureID);
    }

    public void showAllelementsAddMat() {
        if (isEmpty()) System.out.println("""
                Виведемо всі елементи додаткових матеріалів на екран:
                Жодного елементу не знайдено!
                """);
        for (List<AddMaterials> list : addMaterials.values()) {
            if (list == null) continue;
            for (AddMaterials additionalMaterial : list) {
                if (additionalMaterial == null) continue;
                System.out.println("Виведемо всі елементи додаткових матеріалів на екран: " + addMaterials);
            }
        }
    }

    public AddMaterials getNewElement(int ID) {
        for (List<AddMaterials> list : addMaterials.values()) {
            if (list == null) continue;
            for (AddMaterials addMaterial : list) {
                if (addMaterial == null) continue;
                if (addMaterial.getNew() == ID) {
                    System.out.println("Виведемо всі елементи додаткових матеріалів на екран: " + addMaterial);
                    return addMaterial;
                }
            }
        }
        return null;
    }

    public List<AddMaterials> addNewElements() {
        List<AddMaterials> newAddMat = new ArrayList<>();
        for (List<AddMaterials> list : addMaterials.values()) {
            if (list == null) continue;
            for (AddMaterials addMaterial : list) {
                if (addMaterial == null) continue;
                newAddMat.add(addMaterial);
            }
        }
        System.out.println("Виведемо всі елементи додаткових матеріалів на екран: " + newAddMat);
        return newAddMat;
    }
    public static List<AddMaterials> sortAddMatt() {
        List<AddMaterials> addToSort =
                new ArrayList<>((Collection) AddMaterialsRepository.getNewExample().getAddMaterials());
addToSort.sort(new AddMaterialsComparator());
return addToSort;
    }

    public static Map<Integer, List<AddMaterials>> getAddMaterials() {
        return addMaterials;
    }

    public static void setAddMaterials(Map<Integer, List<AddMaterials>> addMaterials) {
        AddMaterialsRepository.addMaterials = addMaterials;
    }

}
