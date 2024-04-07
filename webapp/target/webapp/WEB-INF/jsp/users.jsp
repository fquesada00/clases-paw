<%--
  Created by IntelliJ IDEA.
  User: franq
  Date: 4/7/2024
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
    <link rel="stylesheet" href=
            <c:url value="/css/styles.css"/>/>
</head>
<body>
<section>
    <label>ID</label>
    <div><c:out value="${user.id}"/></div>
</section>
<section>
    <label>First Name</label>
    <div><c:out value="${user.firstName}"/></div>
</section>
<section>
    <label>Last Name</label>
    <div><c:out value="${user.lastName}"/></div>
</section>
<section>
    <label>Email</label>
    <div><c:out value="${user.email}"/></div>
</section>
<section>
    <label>Age</label>
    <div><c:out value="${user.age}"/></div>
</section>
</body>
</html>
