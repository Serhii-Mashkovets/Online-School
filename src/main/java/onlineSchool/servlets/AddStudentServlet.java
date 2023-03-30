package onlineSchool.servlets;

import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet{
    private StudentsRepository repository;

    @Override
    public void init() throws ServletException {
        super.init();
        repository = new StudentsRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Student student = new Student(name, surname, email);

        try {
            repository.add(student);
            resp.sendRedirect(req.getContextPath() + "/WEB-INF/view/students.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
