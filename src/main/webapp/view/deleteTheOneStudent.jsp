<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="onlineSchool.models.Student" %>
<%@ page import="onlineSchool.repository.StudentsRepository" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Delete Student</title>
</head>
<body>
<h1>Delete Student</h1>
<form action="DeleteStudentServlet" method="post">
  <label for="studentId">Enter Student ID:</label>
  <input type="text" id="studentId" name="studentId"><br><br>
  <input type="submit" value="Delete">
</form>
<%
  String studentIdParam = request.getParameter("studentId");
  if (studentIdParam != null) {
    try {
      int studentId = Integer.parseInt(studentIdParam);

      StudentsRepository.getNewExample().removeById(studentId);


      out.println("<p>Student with ID " + studentId + " has been successfully deleted</p>");
    } catch (NumberFormatException e) {
      out.println("<p>Invalid student ID</p>");
    } catch (SQLException e) {
      out.println("<p>Failed to delete student. Error message: " + e.getMessage() + "</p>");
    }
  }
%>

<p><a href="getAllStudents.jsp">Back to student list</a></p>
</body>
</html>