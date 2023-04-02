package onlineSchool.servlets;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/AllStudentsServlet")
public class AllStudentsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students;
        try {
            students = StudentsRepository.getAllStudents();
            System.out.println("students = " + students);
            request.setAttribute("students", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/getAllStudents.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
