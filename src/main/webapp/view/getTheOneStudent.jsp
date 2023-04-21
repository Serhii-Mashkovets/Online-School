<%@ page import="onlineSchool.repository.StudentsRepository" %>
<%@ page import="onlineSchool.models.Student" %>
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
<%
  String studentIdParam = request.getParameter("id");
  if (studentIdParam != null && !studentIdParam.isEmpty()) {
    int studentId = Integer.parseInt(studentIdParam);
    StudentsRepository studentsRepository = null;
    try {
      Optional<Student> student = studentsRepository.findById(studentId);
      if (student.isPresent()) { %>

<p>Ім'я: <%= student.get().getStudentName() %></p>
<p>Прізвище: <%= student.get().getStudentLastName() %></p>
<p>Email: <%= student.get().getEmail() %></p>
<%
    } else {
      throw new EntityNotFoundException("Студент з таким id не знайдено");
    }
  } catch (EntityNotFoundException e) {
    request.setAttribute("error", e.getMessage());
  } catch (NumberFormatException e) {
    request.setAttribute("error", "Помилковий формат параметру id");
  } catch (Exception e) {
    request.setAttribute("error", "Помилка при отриманні інформації про студента");
  }
} else {
%>

<p>Не передано параметр id</p>
<% } %>

</body>
</html>