package onlineSchool.repository;

import onlineSchool.models.AddMaterials;

public class AddMaterialsRepository extends ParentingClassForRepositories {

    private static final int INIT_CAPACITY = 5;
    private AddMaterials[] addMaterialsArray;

    public AddMaterialsRepository() {
        super(1);
        this.setAddMaterialsArray(new AddMaterials[getINIT_CAPACITY()]);
    }

    public AddMaterialsRepository(int inputCapacity) {
        super(1);
        if (inputCapacity < 1) {
            System.out.println("Wrong argument, creating standart capacity array");
            this.setAddMaterialsArray(new AddMaterials[getINIT_CAPACITY()]);
        } else {
            this.setAddMaterialsArray(new AddMaterials[inputCapacity]);
        }
    }

    public int getINIT_CAPACITY() {
        return INIT_CAPACITY;
    }

    public AddMaterials[] getAddMaterialsArray() {
        return addMaterialsArray;
    }

    public void setAddMaterialsArray(AddMaterials[] addMaterialsArray) {
        this.addMaterialsArray = addMaterialsArray;
    }
}
