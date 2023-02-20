package onlineSchool.loggingJournal;

import org.jetbrains.annotations.NotNull;

import java.io.*;


public class LoggingService {

    private static final String FILELOG = "C:\\Users\\finep\\IdeaProjects\\onlineSchool\\src" +
            "\\onlineSchool\\loggingJournal\\Logging registration journal.txt";


    protected static void logToWrite(@NotNull Log log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILELOG, true))) {
            {
                writer.write(log + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
