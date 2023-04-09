package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;
import onlineSchool.hibernateUtil.HibernateUtil;
import onlineSchool.persistanceObjects.StudentCoursesEntityPK;
import onlineSchool.persistanceObjects.StudentsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentsRepository extends ParentingClassForRepositories {
    public List<Optional<Student>> getStudentsByCourseId(int courseId) throws EntityNotFoundException {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            String hql ="SELECT s\n" +
                    "FROM StudentsEntity s\n" +
                    "JOIN StudentCoursesEntity sc ON s.studentId = sc.studentId\n" +
                    "WHERE sc.courseId = :courseId";
            List<StudentsEntity> studentsEntities = session.createQuery(hql, StudentsEntity.class)
                    .setParameter("courseId", courseId)
                    .getResultList();
            if (studentsEntities.isEmpty()) {
                throw new EntityNotFoundException("No student found with the given course id");
            } else {
                return studentsEntities.stream()
                        .map(s -> Optional.of(new Student(s.getStudentName(), s.getStudentSurname(), s.getStudentEmail())))
                        .collect(Collectors.toList());
            }
        }
    }


    public Optional<Student> usingStudentById(int studentId) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            StudentsEntity studentEntity = session.get(StudentsEntity.class, studentId);
            return Optional.ofNullable(studentEntity != null ? new Student(
                    studentEntity.getStudentName(), studentEntity.getStudentSurname(), studentEntity.getStudentEmail()) : null);
        }
    }

    public void add(Student student) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            StudentsEntity studentEntity = new StudentsEntity();
            studentEntity.setStudentName(student.getStudentName());
            studentEntity.setStudentSurname(student.getStudentLastName());
            studentEntity.setStudentEmail(student.getEmail());
            session.save(studentEntity);
            session.getTransaction().commit();
        }
    }

    public void removeById(int studentId) {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            StudentsEntity studentEntity = session.get(StudentsEntity.class, studentId);
            if (studentEntity != null) {
                session.delete(studentEntity);
            }
            session.getTransaction().commit();
        }
    }

    public int sizeCount() {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT COUNT(*) FROM StudentsEntity";
            return Math.toIntExact((long) session.createQuery(sql).getSingleResult());
        }
    }

    public List<Student> getAllStudents() {
        try (var session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "FROM StudentsEntity";
            List<StudentsEntity> studentsEntities = session.createQuery(sql, StudentsEntity.class).getResultList();
            List<Student> students = new ArrayList<>();
            for (StudentsEntity studentEntity : studentsEntities) {
                students.add(new Student( studentEntity.getStudentName(),
                        studentEntity.getStudentSurname(), studentEntity.getStudentEmail()));
            }
            return students;
        }
    }

    public StudentCoursesEntityPK createStudentCoursesPK(int studentId, int courseId){
        StudentCoursesEntityPK studentCoursesPK = new StudentCoursesEntityPK();
        studentCoursesPK.setStudentId(studentId);
        studentCoursesPK.setCourseId(courseId);
        return studentCoursesPK;
    }

}