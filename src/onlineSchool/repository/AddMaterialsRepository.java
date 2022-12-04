package onlineSchool.repository;

import onlineSchool.models.AddMaterials;

public class AddMaterialsRepository {
    private final int INIT_CAPACITY = 5;
    private AddMaterials[] addMaterialsArray;

    public AddMaterialsRepository() {
        this.addMaterialsArray = new AddMaterials[INIT_CAPACITY];
    }

    public AddMaterialsRepository(int inputCapacity) {
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.addMaterialsArray = new AddMaterials[INIT_CAPACITY];
        } else {
            this.addMaterialsArray = new AddMaterials[inputCapacity];
        }
    }
}
