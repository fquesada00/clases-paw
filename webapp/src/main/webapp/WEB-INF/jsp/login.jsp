<%--
  Created by IntelliJ IDEA.
  User: franq
  Date: 4/7/2024
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin: 10px;
            color: #333;
        }

        input[type="text"],
        input[type="password"] {
            width: calc(100% - 20px); /* Adjust width as needed */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-top: 5px;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post" enctype="application/x-www-form-urlencoded">
    <div><label for="username"><spring:message code="loginForm.email"/>: </label> <input id="username" name="j_username" type="text"/></div>
    <div><label for="password"><spring:message code="loginForm.password"/>: </label> <input id="password" name="j_password" type="password"/></div>
    <div><label><input name="j_rememberme" type="checkbox"/> <spring:message code="loginForm.rememberMe"/></label></div>
    <div><input type="submit" value="Login!"/></div>
</form>
</body>
</html>

