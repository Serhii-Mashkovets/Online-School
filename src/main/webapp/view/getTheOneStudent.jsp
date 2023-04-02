<%@ page import="onlineSchool.repository.StudentsRepository" %>
<%@ page import="onlineSchool.models.Student" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Optional" %>
<%@ page import="onlineSchool.exceptions.EntityNotFoundException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Інформація про студента</title>
</head>
<body>
<h1>Інформація про студента</h1>

<form action="${pageContext.request.contextPath}/OneStudentServlet" method="get">
  <label for="studentId">ID студента:</label>
  <input type="text" id="studentId" name="id">
  <button type="submit">Підтвердити</button>
</form>

<% String studentIdParam = request.getParameter("id"); %>

<% if (studentIdParam != null && !studentIdParam.isEmpty()) { %>
<% int studentId = Integer.parseInt(studentIdParam); %>

<% StudentsRepository studentsRepository = StudentsRepository.getNewExample(); %>
<% try {
  Optional<Student> student = studentsRepository.usingStudentById(studentId);
  if (student.isPresent()) { %>

<p>Ім'я: <%= student.get().getStudentName() %></p>
<p>Прізвище: <%= student.get().getStudentLastName() %></p>
<p>Email: <%= student.get().getEmail() %></p>

<%  } else {
  throw new EntityNotFoundException("Студент з таким id не знайдено");
}
} catch (NumberFormatException | SQLException | EntityNotFoundException e) {
  request.setAttribute("error", e.getMessage());
}
%>

<% } else { %>

<p>Не передано параметр id</p>

<% } %>

</body>
</html>
