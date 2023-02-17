package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.HomeWork;
import onlineSchool.repository.HomeWorkRepository;

import java.util.List;

public class HomeWorkService {

    private static LoggingRepository logRep = new LoggingRepository(HomeWorkService.class.getName());
    HomeWorkRepository homeWorkRepository = HomeWorkRepository.getNewExample();

    public HomeWork createHw () {
        logRep.debugLog("Створення домашньої роботи");
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
