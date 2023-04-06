package onlineSchool.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;

import javax.sql.DataSource;
import java.io.IOException;


import java.util.List;


@WebServlet("/AllStudentsServlet")
public class AllStudentsServlet extends HttpServlet {


    private StudentsRepository studentsRepository;

    public void init() {
        studentsRepository = new StudentsRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> students = null;
        try {
            students = studentsRepository.getAllStudents();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/getAllStudents.jsp");
        dispatcher.forward(request, response);
    }
}

