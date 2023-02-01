package onlineSchool.services;

import onlineSchool.models.ResourseType;
import onlineSchool.models.AddMaterials;
import onlineSchool.repository.AddMaterialsRepository;

import java.util.Scanner;

public class AddMaterialService {
    private Integer id;

    public AddMaterials createNewAddMaterial() {
        Scanner sc = new Scanner(System.in);
        int type;
        ResourseType resourseType = null;
        System.out.println("Введіть назву додаткового матеріалу: ");
        String addMatName = sc.nextLine();
        do {
            System.out.println("""
                    Оберіть тип додаткових матеріалів:
                    1. URL;
                    2. Video;
                    3. Book.
                    """);
            type = sc.nextInt();
            switch (type) {
                case 1 -> resourseType = ResourseType.URL;
                case 2 -> resourseType = ResourseType.VIDEO;
                case 3 -> resourseType = ResourseType.BOOK;
                default -> System.out.println("Такий тип не знайдено!");
            }
        } while (type < 1 || type > 3);
        sc.close();
        return new AddMaterials(addMatName, AddMaterials.getId(), resourseType);
    }

    AddMaterialsRepository addMaterialsRepository = AddMaterialsRepository.getNewExample();

    public void showAllAddmat() {
        addMaterialsRepository.showAllelementsAddMat();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
