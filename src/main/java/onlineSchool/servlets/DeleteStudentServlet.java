package onlineSchool.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import onlineSchool.repository.StudentsRepository;


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
