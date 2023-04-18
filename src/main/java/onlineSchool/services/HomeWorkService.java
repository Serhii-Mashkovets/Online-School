package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.HomeWork;
import onlineSchool.repository.HomeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class HomeWorkService {
    @Autowired
    private static LoggingRepository logRep = new LoggingRepository(HomeWorkService.class.getName());

    @Autowired
    HomeWorkRepository homeWorkRepository;


    private final ArrayList <HomeWork> homeWorks = new ArrayList<>();
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

    public Integer getSize() {
        return homeWorks.size();
    }

    public boolean isEmpty() {
        return homeWorks.isEmpty();
    }

    public HomeWork getById(Integer id) {
        return id < homeWorks.size() ? homeWorks.get(id) : null;
    }


    public void add (HomeWork homeWork) {
        homeWorks.add(homeWork);
    }

    public void save (HomeWork homeWork) {
        homeWorkRepository.save(homeWork);
    }

    public List<HomeWork> getAll() {
        Iterable<HomeWork> iterable = homeWorkRepository.findAll();

        List<HomeWork> list = new ArrayList<>();
        for (HomeWork homeWork : iterable) {
            list.add(homeWork);
        }

        return list;
    }


    public void deleteById(Integer id) {
        homeWorkRepository.deleteById(id);
    }
}
