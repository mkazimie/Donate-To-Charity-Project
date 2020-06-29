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
<header class="header">
    <nav class="container container--70">
        <%@ include file="header.jsp" %>
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/form" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h3 class="failed"> ${failed} </h3>
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user">
        <div class="failed"><form:errors path="name"/></div>
        <div class="form-group">
            <form:input name="firstName" path="name" placeholder="Imię"/>
        </div>
        <div class="failed"><form:errors path="lastName"/></div>
        <div class="form-group">
            <form:input name="lastName" path="lastName" placeholder="Nazwisko"/>
        </div>
        <div class="failed"><form:errors path="email"/></div>
        <div class="form-group">
            <form:input name="email" path="email" placeholder="Email"/>
        </div>
        <div class="failed"><form:errors path="password"/></div>
        <div class="form-group">
            <form:password path="password" name="password" placeholder="Hasło"/>
        </div>
        <div class="failed"><form:errors path="matchingPassword"/></div>
        <div class="failed">${matchError}</div>
        <div class="form-group">
            <form:password path="matchingPassword" name="password2" placeholder="Powtórz hasło"/>
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
