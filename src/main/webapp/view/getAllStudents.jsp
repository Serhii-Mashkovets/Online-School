<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список студентів</title>
</head>
<body>
<h1>Список студентів</h1>

<c:if test="${not empty errorMessage}">
    <p>${errorMessage}</p>
</c:if>

<c:if test="${not empty students}">
    <table border="2">
        <thead>
        <tr>
            <th>Ім'я</th>
            <th>Прізвище</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.studentName}</td>
                <td>${student.studentLastName}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>
