package onlineSchool.comparator;

import onlineSchool.models.AddMaterials;

import java.util.Comparator;

public class AddMaterialsComparator implements Comparator<AddMaterials> {
    @Override
    public int compare(AddMaterials o1, AddMaterials o2) {
        return o1.getId().compareTo(o2.getId());
    }

    public int compareByName(AddMaterials o1, AddMaterials o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

    public int compareByType(AddMaterials o1, AddMaterials o2) {
        return o1.getResourseType().compareTo(o2.getResourseType());
    }

}
