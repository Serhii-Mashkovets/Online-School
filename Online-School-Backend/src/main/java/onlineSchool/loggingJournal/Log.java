package onlineSchool.loggingJournal;

import java.time.LocalDateTime;

public class Log {
    private String name;
    private String message;
    private LocalDateTime date;
    private String stacktrace;
    private LevelOfLogging level;

    public Log(String name, LevelOfLogging level, String message) {
        this.name = name;
        this.message = message;
        this.date = LocalDateTime.now();
        this.level = level;
    }


    public String toString() {
        if (stacktrace != null) {
            return "Log{" +
                    "name='" + name + '\'' +
                    ", message='" + message + '\'' +
                    ", date=" + date +
                    ", stacktrace='" + stacktrace + '\'' +
                    ", level=" + level +
                    '}';
        }
        return "Log{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", level=" + level +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public LevelOfLogging getLevel() {
        return level;
    }

    public void setLevel(LevelOfLogging level) {
        this.level = level;
    }
}
