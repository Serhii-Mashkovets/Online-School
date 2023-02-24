package onlineSchool.loggingJournal;

public enum LevelOfLogging {
    OFF(Integer.MAX_VALUE), ERROR(Integer.MAX_VALUE - 1), WARNING(Integer.MAX_VALUE - 2),
    INFO(Integer.MAX_VALUE - 3), DEBUG(Integer.MAX_VALUE - 4);
    private int intValue;

    LevelOfLogging(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }
}
