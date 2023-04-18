package onlineSchool.services;

import onlineSchool.loggingJournal.LoggingRepository;
import onlineSchool.models.Course;
import onlineSchool.models.Lecture;
import onlineSchool.models.Student;
import onlineSchool.models.Teacher;
import onlineSchool.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Transactional
@Service
public class CourseService {


    private LoggingRepository logRep;

    @Autowired
    private AddMaterialsRepository addMaterialsRepository;

    @Autowired
    private HomeWorkRepository homeWorkRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    TeachersRepository teachersRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Course createNewCourse(String courseName,
                                  Optional<Lecture> lectureName,
                                  Optional<Teacher> teacherOne,
                                  Optional<Student> studentOne) {
        return new Course(courseName, Optional.ofNullable(lectureName.orElse(null)),
                Optional.ofNullable(teacherOne.orElse(null)), Optional.ofNullable(studentOne.orElse(null)));
    }

    public Course createNewCourseByUsers() throws EntityNotFoundException {
        Scanner sc = new Scanner( System.in);
        int lectureId = sc.nextInt();
        int teacherId = sc.nextInt();
        int studentId = sc.nextInt();
        Optional<Lecture> lecture = lectureRepository.findById(Long.valueOf(lectureId));
        Optional<Teacher> teacher = teachersRepository.findById(teacherId);
        Optional<Student> student = studentsRepository.findById(studentId);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        Course course = new Course(courseName, null, null, null);
        course.setLectureName(lecture);
        course.setTeacherNameOne(teacher);
        course.setStudentOne(student.orElseThrow(() -> new EntityNotFoundException("Failed to create student")));

        return courseRepository.save(course);
    }

    public Integer getSize() {
        return (int) courseRepository.count();
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add(Course course) {
        courseRepository.save(course);
    }

    public Course findById(Integer id) {
        Optional<Course> course = courseRepository.findById(Long.valueOf(id));
        return course.orElse(null);
    }

    public List<Course> getAll() {
        Iterable<Course> iterable = courseRepository.findAll();
        List<Course> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public void deleteById(Integer id) {
        courseRepository.deleteById(Long.valueOf(id));
    }
}
