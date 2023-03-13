package onlineSchool.loggingJournal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {

    private static final String FILELOG = "C:\\Users\\finep\\IdeaProjects\\onlineSchool\\src\\onlineSchool" +
            "\\loggingJournal\\Logging registration journal.txt";

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILELOG))) {
            {
                String line;
                System.out.println("");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
