<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Students</title>
</head>
<body>
<h1>All Students</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.getStudentId()}</td>
            <td>${student.getStudentName()}</td>
            <td>${student.getStudentLastName()}</td>
            <td>${student.getEmail()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
