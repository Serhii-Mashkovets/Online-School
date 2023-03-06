package onlineSchool.serialization;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Course;

import java.io.*;

public class SerializationForCourse {
    private static final LoggingRepository logRep = new LoggingRepository(SerializationForCourse.class.getName());
    private static final String FILE_PATH = "src/onlineSchool/serialization/SerializationOfCourse.txt";

    public static void serializeFile(Course course) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(course);
        } catch (IOException e) {
           logRep.errorLog(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static Course deserializeFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            return (Course) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logRep.errorLog(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
