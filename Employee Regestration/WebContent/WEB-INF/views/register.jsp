<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 50%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        caption {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        td, th {
            padding: 10px;
        }
        .error {
            color: red;
        }
        input[type="text"],
        input[type="password"],
        input[type="date"] {
            width: 100%;
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
            float: right;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    
</head>
<body>
    
    <form:form action="registerSuccess" method="post" modelAttribute="employeeForm">
        <table>
            <caption>Employee Registration Form</caption>
            <tr>
                <td>Enter Name:</td>
                <td><form:input path="name" /></td>
                <td><form:errors path="name" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Enter Date of Birth:</td>
                <td><form:input type="date" path="dateOfBirth" /></td>
                <td><form:errors path="dateOfBirth" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Gender:</td>
                <td><form:radiobutton path="gender" value="Male" label="Male" />
                    <form:radiobutton path="gender" value="Female" label="Female" />
                    <form:radiobutton path="gender" value="Female" label="Others" /></td>
                <td><form:errors path="gender" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Enter Address:</td>
                <td><form:input path="address" /></td>
                <td><form:errors path="address" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Enter City:</td>
                <td><form:input path="city" /></td>
                <td><form:errors path="city" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Enter State:</td>
                <td><form:input path="state" /></td>
                <td><form:errors path="state" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Enter Email:</td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>

            <tr>
                <td>Enter Password:</td>
                <td><form:password path="password" /></td>
                <td><form:errors path="password" cssClass="error" /></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Register" /></td>
            </tr>
        </table>
      <div style="text-align: center; margin-top: 10px;">
        <a href="login" class="register-button">Login</a>
    </div>
    </form:form>
     
    
</body>

</html>
