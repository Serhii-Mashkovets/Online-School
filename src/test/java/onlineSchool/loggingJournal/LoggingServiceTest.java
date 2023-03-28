package onlineSchool.loggingJournal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoggingServiceTest {

    private static final Log TEST_LOG = new Log("INFO", LevelOfLogging.INFO,"");

    @Test
    void testLogToWrite(@TempDir Path tempDir) throws IOException {
        // given
        Path logFile = tempDir.resolve("test.log");
        LoggingService.FILELOG = logFile.toString();

        // when
        LoggingService.logToWrite(TEST_LOG);

        // then
        List<String> lines = Files.readAllLines(logFile);
        assertEquals(1, lines.size());
        assertTrue(lines.get(0).endsWith(TEST_LOG.toString()));
    }

    @Test
    void testWriteLevelConfig(@TempDir Path tempDir) throws IOException {
        // given
        Path configFile = tempDir.resolve("config.txt");
        LoggingService.writeLevelConfig(LevelOfLogging.ERROR);

        // when
        String level = new BufferedReader(new FileReader(configFile.toFile())).readLine();

        // then
        assertEquals("Рівень = ERROR", level);
    }

    @Test
    void testReadLevelConfig(@TempDir Path tempDir) throws IOException {
        // given
        Path configFile = tempDir.resolve("config.txt");
        try (PrintWriter writer = new PrintWriter(configFile.toFile())) {
            writer.println("Рівень = WARNING");
        }

        // when
        LevelOfLogging level = LoggingService.readLevelConfig();

        // then
        assertEquals(LevelOfLogging.WARNING, level);
    }

    @Test
    void testReadMessageFromFile(@TempDir Path tempDir) throws IOException {
        // given
        Path logFile = tempDir.resolve("test.log");
        try (PrintWriter writer = new PrintWriter(logFile.toFile())) {
            writer.println("INFO: Test message 1");
            writer.println("DEBUG: Test message 2");
            writer.println("INFO: Test message 3");
        }

        // when
        List<String> messages = new ArrayList<>();
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                messages.add(String.valueOf((char) b));
            }
        }));
        LoggingService.FILELOG = logFile.toString();
        LoggingService.readMessageFromFile();

        // then
        assertEquals("Test message 1\nTest message 3\n", String.join("", messages));
    }

    @Test
    void testCountLogs(@TempDir Path tempDir) throws IOException {
        // given
        Path logFile = tempDir.resolve("test.log");
        try (PrintWriter writer = new PrintWriter(logFile.toFile())) {
            writer.println("INFO: Test message 1");
            writer.println("DEBUG: Test message 2");
            writer.println("INFO: Test message 3");
        }

        // when
        long count = LoggingService.countLogs(logFile.toFile());

        // then
        assertEquals(2, count);
    }

}
