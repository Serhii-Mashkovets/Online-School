package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Lecture;
import onlineSchool.models.ResourseType;
import onlineSchool.models.AddMaterials;
import onlineSchool.repository.AddMaterialsRepository;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class AddMaterialService {
    private static LoggingRepository logRep = new LoggingRepository(AddMaterialService.class.getName());
    private Integer id;




    public Map<Lecture, List<AddMaterials>> getAddMaterialsGroupedByLecture() {
        return AddMaterialsRepository.getAll().stream()
                .collect(Collectors.groupingBy(AddMaterials::getLecture));
    }


    Consumer<Map<Integer, List<AddMaterials>>> fullInfo = integerListMap ->
            integerListMap.forEach((key, value) -> {
                System.out.printf("Айді лекції = " + key + '\n');
                for (AddMaterials additionalMaterial : value) {
                    if (additionalMaterial == null) continue;
                    System.out.println(additionalMaterial);
                }
            });

    public void printGroupedByLectures(Map<Integer, List<AddMaterials>> AddmaterialsMap){
        fullInfo.accept(AddmaterialsMap);
    }




    public AddMaterials createNewAddMaterial() {
        logRep.debugLog("Створення додаткових матеріалів");
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

    public void showAllNewAddMatList(List<AddMaterials> list) {
        System.out.println("""
                Повна інформація про: 
                Додаткові матеріали
                """);
        for (AddMaterials addMaterial : list) {
            if (addMaterial == null) continue;
            System.out.println("Додаткові матеріали: " + addMaterial.getName() + ", ID = " + addMaterial.getId());
        }
    }

    public void findAllNewAddMatList(List<AddMaterials> list) {
        System.out.println("""
                "Знайти повну інформацію про: 
                Додаткові матеріали
                """);
        if (addMaterialsRepository.isEmpty()) System.out.println("Жодного елементу не знайдено!");
        for (AddMaterials addMaterial : list) {
            if (addMaterial == null) continue;
            System.out.println(addMaterial);
        }
    }

    public void showAllAddmat() {
        addMaterialsRepository.showAllelementsAddMat();
    }

    public AddMaterialsRepository sortAddMat () {
            AddMaterialsRepository addMaterialsRepository1 = AddMaterialsRepository.getNewExample();
            addMaterialsRepository1.sortAddMatt();
            return addMaterialsRepository1;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
