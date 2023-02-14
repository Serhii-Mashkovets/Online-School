package onlineSchool.services;

import onlineSchool.models.AddMaterials;
import onlineSchool.models.HomeWork;
import onlineSchool.repository.HomeWorkRepository;

import java.util.List;

public class HomeWorkService {
    HomeWorkRepository homeWorkRepository = HomeWorkRepository.getNewExample();

    public HomeWork createHw () {
        return new HomeWork();
    }

    public void showAllNewHomeWorkList(List<HomeWork> list) {
        System.out.println("""
                Повна інформація про: 
                Домашню роботу 
                """);
        for (HomeWork homeWork : list) {
            if (homeWork == null) continue;
            System.out.println("Домашня робота: " + homeWork + ", ID = " + homeWork.getId());
        }
    }

    public void findAllNewHomeWorkList(List<HomeWork> list) {
        System.out.println("""
                "Знайти повну інформацію про: 
                Домашню роботу 
                """);
        if (homeWorkRepository.isEmpty()) System.out.println("Жодного елементу не знайдено!");
        for (HomeWork homeWork : list) {
            if (homeWork == null) continue;
            System.out.println(homeWork);
        }
    }

}
