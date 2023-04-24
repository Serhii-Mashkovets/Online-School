package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.AddMaterials;
import onlineSchool.models.Lecture;
import onlineSchool.models.ResourseType;
import onlineSchool.repository.AddMaterialsRepository;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AddMaterialService {
@Autowired
    private AddMaterialsRepository addMaterialsRepository;
    private static final LoggingRepository logRep = new LoggingRepository(AddMaterialService.class.getName());
    private Integer id;

    public static void groupAddMatByLectures(List<AddMaterials> materials, List<Lecture> lectures) {
        Map<Integer, List<AddMaterials>> materialsByLecture = materials.stream()
                .collect(Collectors.groupingBy(AddMaterials::getLectureId));

        materialsByLecture.forEach((lectureId, materialList) -> {
            Lecture lecture = lectures.stream()
                    .filter(l -> l.getId().equals(lectureId))
                    .findFirst()
                    .orElse(null);
            if (lecture == null) {
                System.out.println("Лекцію з id " + lectureId + " не знайдено!");
            } else {
                System.out.println(lecture.getLectureName() + ":");
                materialList.forEach(material -> System.out.println("\t" + material.getName()));
            }
        });
    }

    public Map<Lecture, List<AddMaterials>> getAddMaterialsGroupedByLecture() {
        return addMaterialsRepository.findAll().stream()
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
        } while (type < 1 || type >
                3);
        sc.close();
        return new AddMaterials(addMatName, AddMaterials.getId(), resourseType);
    }

    @Transactional
    public void showAllNewAddMatList() {
        addMaterialsRepository.findAll();
    }

    public void saveAddMaterial(Integer addMaterialId, String newName, ResourseType newType) {
        AddMaterials addMaterial = addMaterialsRepository.getById(addMaterialId);
        if (addMaterial == null) {
            System.out.println("Додатковий матеріал з id " + addMaterialId + " не знайдено!");
            return;
        }
        addMaterial.setName(newName);
        addMaterial.setResourseType(newType);
        addMaterialsRepository.save(addMaterial);
    }

    public void deleteAddMaterial(Integer addMaterialId) {
        AddMaterials addMaterial = addMaterialsRepository.getById(addMaterialId);
        if (addMaterial == null) {
            System.out.println("Додатковий матеріал з id " + addMaterialId + " не знайдено!");
            return;
        }
        addMaterialsRepository.delete(addMaterial);
    }


    private final ArrayList<AddMaterials> addMaterials = new ArrayList<>();

    public Integer getSize() {
        return addMaterials.size();
    }

    public boolean isEmpty() {
        return addMaterials.isEmpty();
    }

    public void add(AddMaterials addMaterial) {
        addMaterials.add(addMaterial);
    }

    public List<AddMaterials> getAll() {
        return this.addMaterials;
    }

    public void delete (AddMaterials addMaterials) {
        addMaterialsRepository.delete(addMaterials);
    }


    public Optional<AddMaterials> findById (Integer id) {
       return addMaterialsRepository.findById(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
