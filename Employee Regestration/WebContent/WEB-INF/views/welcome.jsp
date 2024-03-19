<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        h1, h2 {
            text-align: center;
        }
    </style>
</head>
<body>
    <h3 align="right"><a href="logout">Logout</a></h3>
    
    <h1> ${userMessage} ${employeeForm.name}</h1>
    
    <h2>List of Users</h2>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>City</th>
                <th>State</th>
                <th>DateOfBirth</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${allUsers}">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.address}</td>
                    <td>${user.city}</td>
                    <td>${user.state}</td>
                    <td>${user.dateOfBirth}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
