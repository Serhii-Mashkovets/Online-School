package onlineSchool.loggingJournal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoggingRepository extends LogParenting {
    private String desription;
    List<Log> log = new ArrayList<>();

    public LoggingRepository(String description) {
        this.setDesription(description);
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

    public Log errorLog(String message, Throwable ex) {
        Log errorLog = new Log(desription, LevelOfLogging.ERROR, message);
        errorLog.setStacktrace(Arrays.toString(ex.getStackTrace()));
        log.add(errorLog);
        LoggingService.logToWrite(errorLog);
        return errorLog;
    }

    public Log warningLog(String message, Throwable ex) {
        Log wrngLog = new Log(desription, LevelOfLogging.WARNING, message);
        wrngLog.setStacktrace(Arrays.toString(ex.getStackTrace()));
        log.add(wrngLog);
        LoggingService.logToWrite(wrngLog);
        return wrngLog;
    }

    public Log infoLog(String message) {
        Log informationLog = new Log(desription, LevelOfLogging.INFO, message);
        log.add(informationLog);
        LoggingService.logToWrite(informationLog);
        return informationLog;
    }

    public Log debugLog(String message) {
        Log debugLog = new Log(desription, LevelOfLogging.DEBUG, message);
        log.add(debugLog);
        LoggingService.logToWrite(debugLog);
        return debugLog;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}
