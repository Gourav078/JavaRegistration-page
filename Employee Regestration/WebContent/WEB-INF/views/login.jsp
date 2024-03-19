<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        h1 {
            margin-top: 50px;
        }
        table {
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        td {
            padding: 10px;
            text-align: center;
        }
        input[type="text"],
        input[type="password"] {
            width: 200px;
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            font-size: 12px;
        }
    </style>
    
</head>
<body>
<h1 align="center">${headerMessage}</h1>
    <form:form action="loginSuccess" method="post" modelAttribute="employeeForm">
        <table>
            <tr>
                <td>Enter Email:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Enter Password:</td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>

            <tr>
                <td colspan="3" align="center"><input type="submit" value="Login"></td>
            </tr>
        </table>
    </form:form>
       <div style="text-align: center; margin-top: 10px;">
        <a href="register" class="register-button">Register</a>
    </div>
</body>
</html>
