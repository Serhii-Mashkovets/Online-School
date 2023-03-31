package onlineSchool.servlets;

import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/AllStudentsServlet")
public class AllStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
