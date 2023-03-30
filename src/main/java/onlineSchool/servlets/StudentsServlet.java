package onlineSchool.servlets;

import jakarta.servlet.annotation.WebServlet;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet ("/StudentsServlet")
public class StudentsServlet extends HttpServlet {
    private final StudentsRepository studentsRepository;

    public StudentsServlet(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/view/deleteTheOneStudent.jsp")) {
            int studentId = Integer.parseInt(req.getParameter("id"));
            try {
                studentsRepository.removeById(studentId);
                resp.sendRedirect("/view/getAllStudents.jsp");
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else if (uri.equals("/view/getAllStudents.jsp")) {
            try {
                List<Student> students = studentsRepository.getAllStudents();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/WEB-INF/jsp/students.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else if (uri.equals("/view/getTheOneStudent.jsp")) {
            int studentId = Integer.parseInt(req.getParameter("id"));
            try {
                Optional<Student> optionalStudent = studentsRepository.usingStudentById(studentId);
                if (optionalStudent.isPresent()) {
                    req.setAttribute("student", optionalStudent.get());
                    req.getRequestDispatcher("/WEB-INF/jsp/student.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect("/view/getAllStudents.jsp");
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("//view/deleteTheOneStudent.jsp")) {
            int studentId = Integer.parseInt(req.getParameter("id"));
            try {
                studentsRepository.removeById(studentId);
                resp.sendRedirect("/view/getAllStudents.jsp");
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
    }
}
