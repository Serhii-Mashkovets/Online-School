package onlineSchool.loggingJournal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static onlineSchool.loggingJournal.LoggingRepository.*;
import static org.junit.jupiter.api.Assertions.*;

class LoggingRepositoryTest {
    @Test
    public void testErrorLog() {
        LoggingRepository repository = new LoggingRepository("test description");
        Throwable ex = new Exception("test exception");
        repository.errorLog("test error message", ex);
        assertEquals(1, log.size());
        Log errorLog = log.get(0);
        assertEquals(LevelOfLogging.ERROR, errorLog.getLevel());
        assertEquals("test error message", errorLog.getMessage());
        assertEquals(Arrays.toString(ex.getStackTrace()), errorLog.getStacktrace());
    }

    @Test
    public void testWarningLog() {
        LoggingRepository repository = new LoggingRepository("test description");
        Throwable ex = new Exception("test exception");
        warningLog("test warning message", ex);
        assertEquals(1, repository.log.size());
        Log warningLog = repository.log.get(0);
        assertEquals(LevelOfLogging.WARNING, warningLog.getLevel());
        assertEquals("test warning message", warningLog.getMessage());
        assertEquals(Arrays.toString(ex.getStackTrace()), warningLog.getStacktrace());
    }

    @Test
    public void testInfoLog() {
        LoggingRepository repository = new LoggingRepository("test description");
        repository.infoLog("test information message");
        assertEquals(1, repository.log.size());
        Log infoLog = repository.log.get(0);
        assertEquals(LevelOfLogging.INFO, infoLog.getLevel());
        assertEquals("test information message", infoLog.getMessage());
    }

    @Test
    public void testDebugLog() {
        LoggingRepository repository = new LoggingRepository("test description");
        setLevelValue(LevelOfLogging.DEBUG.getIntValue());
        debugLog("test debug message");
        assertEquals(1, repository.log.size());
        Log debugLog = repository.log.get(0);
        assertEquals(LevelOfLogging.DEBUG, debugLog.getLevel());
        assertEquals("test debug message", debugLog.getMessage());
    }
}