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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@WebServlet("/AllStudentsServlet")
public class AllStudentsServlet extends HttpServlet {
    private StudentsRepository studentsRepository;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Iterable<Student> studentsEntities = studentsRepository.findAll();
            List<Student> students = StreamSupport.stream(studentsEntities.spliterator(), false)
                    .map(entity -> new Student(entity.getStudentName(), entity.getStudentLastName()))
                    .collect(Collectors.toList());
            request.setAttribute("students", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/getAllStudents.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
