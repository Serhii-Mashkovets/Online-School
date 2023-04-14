<%@ page import="onlineSchool.repository.StudentsRepository" %>
<%@ page import="onlineSchool.models.Student" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список студентів</title>
</head>
<body>
<h1>Список студентів</h1>

<%
    StudentsRepository studentsRepository = new StudentsRepository();
    try {
        List<Student> students;
        students = studentsRepository.getAllStudents();
        if (students.isEmpty()) {
%>

<p>Не знайдено жодного студента</p>

<% } else { %>

<table border="2">
    <thead>
    <tr>

        <th>Ім'я</th>
        <th>Прізвище</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <% for (Student student : students) { %>
    <tr>

        <td><%= student.getStudentName() %></td>
        <td><%= student.getStudentLastName() %></td>
        <td><%= student.getEmail() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<% }
} catch (Exception e) {
    request.setAttribute("error", e.getMessage());
}
%>

</body>
</html>
