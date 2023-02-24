package onlineSchool.loggingJournal;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


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

    public static void writeLevelConfig(LevelOfLogging level) {
        String string = level.name();
        File file = new File("src/onlineSchool/loggingJournal/config.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Рівень = " + string);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static LevelOfLogging readLevelConfig() {
        Path path = Path.of("src/onlineSchool/loggingJournal/config.txt");
        LevelOfLogging level = LevelOfLogging.OFF;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String lvl = br.readLine();
            if (lvl.startsWith("Рівень = "))
                level = LevelOfLogging.valueOf(lvl.substring(8));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return level;
    }

}
