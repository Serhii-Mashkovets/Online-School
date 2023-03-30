<%@ page import="onlineSchool.repository.StudentsRepository" %>
<%@ page import="onlineSchool.models.Student" %>
<%@ page import="java.sql.SQLException" %>
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

<form method="get">
  <label for="studentId">ID студента:</label>
  <input type="text" id="studentId" name="studentId">
  <button type="submit">Підтвердити</button>
</form>

<% String studentIdParam = request.getParameter("studentId"); %>

<% if (studentIdParam != null && !studentIdParam.isEmpty()) { %>
<% int studentId = Integer.parseInt(studentIdParam); %>

<% StudentsRepository studentsRepository = new StudentsRepository(); %>
<% Student student = null;
  try {
    student = studentsRepository.usingStudentById(studentId).orElse(null);
  } catch (SQLException e) {
    throw new RuntimeException(e);
  } %>

<% if (student != null) { %>

<p>Ім'я: <%= student.getStudentName() %></p>
<p>Прізвище: <%= student.getStudentLastName() %></p>
<p>Email: <%= student.getEmail() %></p>
<% } else { %>

<p>Студент з id <%= studentId %> не знайдено</p>
<% } %>
<% } else { %>

<p>Не передано параметр studentId</p>
<% } %>
</body>
</html>