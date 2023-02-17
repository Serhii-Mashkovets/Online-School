package onlineSchool.loggingJournal;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class LoggingService {

    static File fileLog = new File("src/onlineSchool/loggingJournal/Logging registration journal.txt");

    public static void logToWrite(@NotNull Log log)  {
        String stringLog = log.toString();
        try {
            FileWriter writer = new FileWriter(fileLog, true);{
                writer.write(stringLog);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public String logToRead() {
        char[] buffer = null;
        try (FileReader reader = new FileReader(fileLog)){
            buffer = new char[(int) fileLog.length()];
            reader.read(buffer);
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return new String(buffer);
    }

}
