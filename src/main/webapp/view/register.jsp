<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>
<h2>Registration Form</h2>
<form method="post" action="${pageContext.request.contextPath}/register">
    <table>
        <tr>
            <td><label for="username">Username:</label></td>
            <td><input type="text" id="username" name="username" value="${user.username}" /></td>
            <td><form:errors path="username" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input type="password" id="password" name="password" value="${user.password}" /></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label for="confirmPassword">Confirm Password:</label></td>
            <td><input type="password" id="confirmPassword" name="confirmPassword" value="${user.confirmPassword}" /></td>
            <td><form:errors path="confirmPassword" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label for="email">Email:</label></td>
            <td><input type="text" id="email" name="email" value="${user.email}" /></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Register" /></td>
        </tr>
    </table>
</form>
</body>
</html>
