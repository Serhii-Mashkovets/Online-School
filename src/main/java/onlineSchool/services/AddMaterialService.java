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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddMaterialService {

    @Autowired
    private AddMaterialsRepository addMaterialsRepository;
    @Autowired
    private static LoggingRepository logRep = new LoggingRepository(AddMaterialService.class.getName());
    private Integer id;

    public static void groupAddMatByLectures ( List <AddMaterials> materials, List <Lecture> lecture) {
        Map<Integer, List<AddMaterials>> materialsByLecture = materials.stream()
                .collect(Collectors.groupingBy(AddMaterials::getLectureId));

        materialsByLecture.forEach((getLectureId, materialList) -> {
            System.out.println(lecture + ":");
            materialList.forEach(material -> System.out.println("\t" + material.getName()));
        });
    }

    public Map<Lecture, List<AddMaterials>> getAddMaterialsGroupedByLecture() {
        return addMaterialsRepository.getAll().stream()
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

    public static AddMaterials createNewAddMaterial() {
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

    @Transactional
    public void showAllNewAddMatList() {
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
