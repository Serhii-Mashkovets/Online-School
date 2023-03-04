package onlineSchool.ipChecker;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.repository.CourseRepository;

import java.io.IOException;
import java.nio.file.*;

import static onlineSchool.ipChecker.Server.readBlackList;

public class BlackListChecker implements Runnable {
    private static LoggingRepository logRep = new LoggingRepository(BlackListChecker.class.getName());

    public void blackListChecker() throws InterruptedException, IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("src/onlineSchool/ipChecker/");
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                if ((event.context()).toString().equals("BlackList.txt")) {
                    Server.setBlackList(readBlackList());
                }
            }
            key.reset();
        }
        watchService.close();
    }

    @Override
    public void run() {
        logRep.debugLog("Запуск методу blackListChecker в класі BlackListChecker.");
        try {
            blackListChecker();
        } catch (IOException | InterruptedException e) {
            logRep.warningLog("Некоректне завершення методу" +
                    " blackListChecker в класі BlackListChecker через помилку: ", e);
        }
        logRep.debugLog("Вихід з методу blackListChecker в класі BlackListChecker.");
    }

}
