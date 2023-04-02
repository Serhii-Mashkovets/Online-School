package onlineSchool.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import onlineSchool.exceptions.EntityNotFoundException;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet ("/OneStudentServlet")
public class OneStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            int studentId = Integer.parseInt(req.getParameter("id"));
            StudentsRepository studentsRepository = StudentsRepository.getNewExample();

            Optional<Student> student = studentsRepository.usingStudentById(studentId);
            if (student.isPresent()) {

                req.setAttribute("student", student.get());
                req.getRequestDispatcher("/view/getTheOneStudent.jsp").forward(req, resp);
            } else {

                throw new EntityNotFoundException("Студент з таким id не знайдено");
            }
        } catch (NumberFormatException | SQLException | EntityNotFoundException e) {
            req.setAttribute("error", e.getMessage());
        }
    }
}
