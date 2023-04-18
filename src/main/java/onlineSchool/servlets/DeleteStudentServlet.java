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

    StudentsRepository studentsRepository;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        try {
            studentsRepository.deleteById(studentId);
            response.sendRedirect(request.getContextPath() + "/view/getAllStudents.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
