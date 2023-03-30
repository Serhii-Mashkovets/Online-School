package onlineSchool.servlets;

import onlineSchool.repository.StudentsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        try {
            StudentsRepository.getNewExample().removeById(studentId);
            response.sendRedirect(request.getContextPath() + "/view/students.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
