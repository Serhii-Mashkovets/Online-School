package onlineSchool.loggingJournal;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class LoggingService {

    public static String FILELOG = "C:\\Users\\finep\\IdeaProjects\\onlineSchool\\src\\main\\java\\onlineSchool\\loggingJournal\\Logging registration journal.txt";


    protected static void logToWrite(Log log) {
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
        File file = new File("C:\\Users\\finep\\IdeaProjects\\onlineSchool\\src\\main\\java\\onlineSchool\\loggingJournal\\config.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Рівень = " + string);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static LevelOfLogging readLevelConfig() {
        Path path = Path.of("C:\\Users\\finep\\IdeaProjects\\onlineSchool\\src\\main\\java\\onlineSchool\\loggingJournal\\config.txt");
        LevelOfLogging level = LevelOfLogging.DEBUG;
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String lvl = br.readLine();
            if (lvl.startsWith("Рівень = "))
                level = LevelOfLogging.valueOf(lvl.substring(9));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return level;
    }




    public static void readMessageFromFile () {
        System.out.println("Виведемо строки з файлу , де містяться повідомлення");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILELOG))) {
            reader.lines()
                    .filter(line -> line.contains("message"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static long countLogs(File logFile) throws IOException {
        Path path = logFile.toPath();
        try {
            long totalLines = Files.lines(path).count();
            long skippedLines = totalLines / 2;
            try (Stream<String> lines = Files.lines(path).skip(skippedLines)) {
                return lines.filter(line -> line.contains("INFO")).count();
            }
        } catch (IOException e) {
            throw new IOException("Exception: " + e);
        }

    }

}
