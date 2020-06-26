<%--
  Created by IntelliJ IDEA.
  User: magdalena
  Date: 24.06.2020
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header>
    <%@ include file="header.jsp" %>
</header>

<section class="login-page">
    <h3 class="failed"> ${failed} </h3>
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user">
        <div class="form-group">
            <form:input name="firstName" path="name" placeholder="Imię"/>
            <form:errors path="name" cssClass="failed"/>
        </div>
        <div class="form-group">
            <form:input name="lastName" path="lastName" placeholder="Nazwisko"/>
            <form:errors path="lastName" cssClass="failed"/>
        </div>
        <div class="form-group">
            <form:input name="email" path="email" placeholder="Email"/>
            <form:errors path="email" cssClass="failed"/>
        </div>
        <div class="form-group">
            <form:password path="password" name="password" placeholder="Hasło"/>
            <form:errors path="password" cssClass="failed"/>

        </div>
        <div class="form-group">
            <form:password path="matchingPassword" name="password2" placeholder="Powtórz hasło"/>
            <form:errors path="matchingPassword" cssClass="failed"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<%@ include file="footer.jsp" %>
</body>
</html>
