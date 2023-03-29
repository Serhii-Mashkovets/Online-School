package onlineSchool.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet ("/StudentsServlet")
public class StudentsServlet extends HttpServlet {
    private final StudentsRepository studentRepository = new StudentsRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = null;
        try {
            students = studentRepository.getAllStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Math.toIntExact(Long.parseLong(request.getParameter("id")));
        Optional<Student> student;
        try {
            student = studentRepository.usingStudentById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("student", student);
        request.getRequestDispatcher("/student.jsp").forward(request, response);
    }


}
