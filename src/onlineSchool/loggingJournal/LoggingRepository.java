package onlineSchool.loggingJournal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoggingRepository extends LogParenting {
    private static String description;

    private static int levelValue;
    static List<Log> log = new ArrayList<>();

    public LoggingRepository(String description) {

        this.setDesription(description);
        levelValue = LoggingService.readLevelConfig().getIntValue();
    }

    public boolean add(Log logg) {
        return log.add(logg);
    }

    public Object remove(int num) {
        return log.remove(num);
    }


    public Object getE(int num) {
        return log.get(num);
    }

    public void errorLog(String message, Throwable ex) {
        if (!isAvailableForLogging(LevelOfLogging.ERROR)) return;
        Log errorLog = new Log(description, LevelOfLogging.ERROR, message);
        errorLog.setStacktrace(Arrays.toString(ex.getStackTrace()));
        log.add(errorLog);
        LoggingService.logToWrite(errorLog);
    }

    public static void warningLog(String message, Throwable ex) {
        if (!isAvailableForLogging(LevelOfLogging.WARNING)) return;
        Log wrngLog = new Log(description, LevelOfLogging.WARNING, message);
        wrngLog.setStacktrace(Arrays.toString(ex.getStackTrace()));
        log.add(wrngLog);
        LoggingService.logToWrite(wrngLog);
    }

    public void infoLog(String message) {
        if (!isAvailableForLogging(LevelOfLogging.INFO)) return;
        Log informationLog = new Log(description, LevelOfLogging.INFO, message);
        log.add(informationLog);
        LoggingService.logToWrite(informationLog);
    }

    public static void debugLog(String message) {
        if (!isAvailableForLogging(LevelOfLogging.DEBUG)) return;
        Log debugLog = new Log(description, LevelOfLogging.DEBUG, message);
        log.add(debugLog);
        LoggingService.logToWrite(debugLog);
    }

    public static boolean isAvailableForLogging(LevelOfLogging level) {
        return level.getIntValue() >= levelValue;
    }

    public String getDesription() {
        return description;
    }

    public void setDesription(String desription) {
        this.description = desription;
    }

    public static int getLevelValue() {
        return levelValue;
    }

    public static void setLevelValue(int levelValue) {
        LoggingRepository.levelValue = levelValue;
    }
}
