package onlineSchool.repository;

import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;
import onlineSchool.hibernateUtil.HibernateUtil;
import onlineSchool.persistanceObjects.CoursesEntity;
import onlineSchool.persistanceObjects.StudentCoursesEntity;
import onlineSchool.persistanceObjects.StudentCoursesEntityPK;
import onlineSchool.persistanceObjects.StudentsEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentsRepository extends ParentingClassForRepositories {

    private SessionFactory sessionFactory;

    public StudentsRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Optional<Student>> getStudentsByCourseId(int courseId) throws EntityNotFoundException {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            String hql = "SELECT s FROM StudentsEntity s JOIN FETCH s.courses c WHERE c.courseId = :courseId";
            Query<StudentsEntity> query = session.createQuery(hql, StudentsEntity.class);
            query.setParameter("courseId", courseId);
            List<StudentsEntity> studentsEntities = query.getResultList();
            if (studentsEntities.isEmpty()) {
                tx.rollback();
                throw new EntityNotFoundException("No student found with the given course id");
            } else {
                List<Optional<Student>> optionalStudents = studentsEntities.stream()
                        .map(s -> Optional.of(new Student(s.getStudentName(), s.getStudentSurname(), s.getStudentEmail())))
                        .collect(Collectors.toList());
                tx.commit();
                return optionalStudents;
            }
        }
    }

    public Optional<Student> usingStudentById(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            StudentsEntity studentEntity = session.get(StudentsEntity.class, studentId);
            Optional<Student> optionalStudent = Optional.ofNullable(studentEntity != null ? new Student(
                    studentEntity.getStudentName(), studentEntity.getStudentSurname(), studentEntity.getStudentEmail()) : null);
            tx.commit();
            return optionalStudent;
        }
    }

    public void add(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            StudentsEntity studentEntity = new StudentsEntity();
            studentEntity.setStudentName(student.getStudentName());
            studentEntity.setStudentSurname(student.getStudentLastName());
            studentEntity.setStudentEmail(student.getEmail());
            session.save(studentEntity);
            tx.commit();
        }
    }

    public void removeById(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            StudentsEntity studentEntity = session.get(StudentsEntity.class, studentId);
            if (studentEntity != null) {
                session.delete(studentEntity);
            }
            tx.commit();
        }
    }

    public int sizeCount() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            String sql = "SELECT COUNT(*) FROM StudentsEntity";
            Query<Long> query = session.createQuery(sql, Long.class);
            Long count = query.getSingleResult();
            tx.commit();
            return Math.toIntExact(count);
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            String hql = "FROM StudentsEntity";
            Query<StudentsEntity> query = session.createQuery(hql, StudentsEntity.class);
            List<StudentsEntity> studentsEntities = query.getResultList();
            List<Student> students = studentsEntities.stream()
                    .map(studentEntity -> new Student(studentEntity.getStudentName(), studentEntity.getStudentSurname(), studentEntity.getStudentEmail()))
                    .collect(Collectors.toList());
            tx.commit();
            return students;
        }
    }


    public void registerToCourse(int studentId, int courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            StudentsEntity studentEntity = session.get(StudentsEntity.class, studentId);
            CoursesEntity courseEntity = session.get(CoursesEntity.class, courseId);
            if (studentEntity != null && courseEntity != null) {
                StudentCoursesEntity studentCoursesEntity = new StudentCoursesEntity();
                studentCoursesEntity.setStudent(studentEntity);
                studentCoursesEntity.setCourse(courseEntity);
                studentCoursesEntity.setStudentCoursesEntityPK(new StudentCoursesEntityPK(studentId, courseId));
                session.save(studentCoursesEntity);
            }
            tx.commit();
        }
    }

    public void unregisterFromCourse(int studentId, int courseId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            StudentCoursesEntityPK studentCoursesEntityPK = new StudentCoursesEntityPK(studentId, courseId);
            StudentCoursesEntity studentCoursesEntity = session.get(StudentCoursesEntity.class, studentCoursesEntityPK);
            if (studentCoursesEntity != null) {
                session.delete(studentCoursesEntity);
            }
            tx.commit();
        }
    }



    public StudentCoursesEntityPK createStudentCoursesPK(int studentId, int courseId){
        StudentCoursesEntityPK studentCoursesPK = new StudentCoursesEntityPK( studentId, courseId);
        studentCoursesPK.setStudentId(studentId);
        studentCoursesPK.setCourseId(courseId);
        return studentCoursesPK;
    }
}
