<%--
  Created by IntelliJ IDEA.
  User: franq
  Date: 4/7/2024
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="<c:url value='/css/styles.css'/>"/>
</head>
<body>
<c:url value="/users/create" var="postPath"/>
<form:form modelAttribute="registerForm" action="${postPath}" method="post">
    <section>
        <form:label path="firstName"><spring:message code="registerForm.firstName" /></form:label>
        <form:input type="text" path="firstName"/>
        <form:errors path="firstName" cssClass="formError" element="p"/>
    </section>
    <section>
        <form:label path="lastName"><spring:message code="registerForm.lastName" /></form:label>
        <form:input type="text" path="lastName"/>
        <form:errors path="lastName" cssClass="formError" element="p"/>
    </section>
    <section>
        <form:label path="email"><spring:message code="registerForm.email" /></form:label>
        <form:input type="email" path="email"/>
        <form:errors path="email" cssClass="formError" element="p"/>
    </section>
    <section>
        <form:label path="age"><spring:message code="registerForm.age" /></form:label>
        <form:input type="number" path="age"/>
        <form:errors path="age" cssClass="formError" element="p"/>
    </section>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>
