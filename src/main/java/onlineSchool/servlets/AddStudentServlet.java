package onlineSchool.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import onlineSchool.models.Student;
import onlineSchool.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/AddStudent")
public class AddStudentServlet {
    private final StudentsRepository repository;

    @Autowired
    public AddStudentServlet(StudentsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    protected String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "students";
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String doPost(HttpServletRequest req) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Student student = new Student(name, surname, email);
        repository.save(student);
        return "redirect:/view/students.jsp";
    }
}
