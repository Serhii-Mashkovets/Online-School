package onlineSchool.loggingJournal;

import onlineSchool.Main;


import java.io.IOException;
import java.nio.file.*;

public class LevelWatcher implements Runnable {
    private static LoggingRepository logRep = new LoggingRepository(Main.class.getName());

    public void watcherlvl() throws InterruptedException, IOException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("src/main/java/onlineSchool/loggingJournal/");
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                if ((event.context()).toString().equals("config.txt")) {
                    LoggingRepository.setLevelValue(LoggingService.readLevelConfig().getIntValue());
                }
            }
            key.reset();
        }
        watchService.close();
    }

    @Override
    public void run() {
        LoggingRepository.debugLog("Запуск LevelWatcher.");
        try {
            watcherlvl();
        } catch (IOException | InterruptedException e) {
            LoggingRepository.warningLog("Можливе некоректне завершення методу. " + "\n" +
                    "Вихід із LevelWatcher через перерване виключення: ", e);
        }
        LoggingRepository.debugLog("Вихід із LevelWatcher.");
    }
}
