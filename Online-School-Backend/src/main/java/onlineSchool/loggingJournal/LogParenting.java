package onlineSchool.loggingJournal;

import java.util.ArrayList;
import java.util.List;

public abstract class LogParenting<E> {
    List<E> eList = new ArrayList<>();
    private String description;
    private int numberForLog;

    public LogParenting(String description) {
        this.description = description;
    }

    public LogParenting(String description, int numberForLog) {
        this.description = description;
        this.numberForLog = numberForLog;
    }

    protected LogParenting() {
    }

    public boolean add(E e) {
        return eList.add(e);
    }

    public E remove(int numberIndex) {
        return eList.remove(numberIndex);
    }

    public E getE(int numberIndex) {
        return eList.get(numberIndex);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberForLog() {
        return numberForLog;
    }

    public void setNumberForLog(int numberForLog) {
        this.numberForLog = numberForLog;
    }
}
