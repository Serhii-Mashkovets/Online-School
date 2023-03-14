package onlineSchool.loggingJournal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LoggingServiceTest {

    private static final String TEST_LOG_FILE = "testLogFile.txt";
    private static final String TEST_CONFIG_FILE = "testConfigFile.txt";

    @BeforeAll
    static void setup() {
        File logFile = new File(TEST_LOG_FILE);
        if (logFile.exists()) {
            logFile.delete();
        }
        File configFile = new File(TEST_CONFIG_FILE);
        if (configFile.exists()) {
            configFile.delete();
        }
    }

    @Test
    void testLogToWrite() throws IOException {
        Log log = new Log("INFO", LevelOfLogging.INFO, "This is INFO Log Test");
        LoggingService.logToWrite(log);
        List<String> lines = Files.readAllLines(Path.of(TEST_LOG_FILE));
        Assertions.assertEquals(1, lines.size());
        Assertions.assertEquals(log.toString(), lines.get(0));
    }

    @Test
    void testWriteLevelConfig() throws IOException {
        LevelOfLogging level = LevelOfLogging.DEBUG;
        LoggingService LoggingUtils;
        LoggingService.writeLevelConfig(level);
        List<String> lines = Files.readAllLines(Path.of(TEST_CONFIG_FILE));
        Assertions.assertEquals(1, lines.size());
        Assertions.assertEquals("Рівень = " + level.name(), lines.get(0));
    }

    @Test
    void testReadLevelConfig() throws IOException {
        LevelOfLogging expectedLevel = LevelOfLogging.INFO;
        Files.write(Path.of(TEST_CONFIG_FILE), ("Рівень = " + expectedLevel.name()).getBytes());
        LevelOfLogging actualLevel = LoggingService.readLevelConfig();
        Assertions.assertEquals(expectedLevel, actualLevel);
    }

    @Test
    void testReadMessageFromFile() throws IOException {
        Files.write(Path.of(TEST_LOG_FILE), "INFO: Test message\nWARNING: Test message\n".getBytes());
        LoggingService.readMessageFromFile();
    }

    @Test
    void testCountLogs() throws IOException {
        Files.write(Path.of(TEST_LOG_FILE), "INFO: Test message\nWARNING: Test message\nINFO: Test message\n".getBytes());
        File logFile = new File(TEST_LOG_FILE);
        long expectedCount = 2;
        long actualCount = LoggingService.countLogs(logFile);
        Assertions.assertEquals(expectedCount, actualCount);
    }

}
