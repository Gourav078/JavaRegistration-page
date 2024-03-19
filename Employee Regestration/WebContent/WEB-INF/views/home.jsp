<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<style>
    /* Style for buttons */
    .button {
        display: inline-block;
        padding: 10px 20px;
        background-color: #007bff; /* Blue color */
        color: #fff; /* White text */
        text-decoration: none;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    /* Hover effect */
    .button:hover {
        background-color: #0056b3; /* Darker blue */
    }
</style>
</head>
<body>
<h1 align="center">${headerMessage}</h1>
<table align="center">
    <tr>
        <td><a href="${pageContext.request.contextPath}/login" class="button">Login</a></td>
        <td><a href="${pageContext.request.contextPath}/register" class="button">Register</a></td>
    </tr>
</table>
</body>
</html>
