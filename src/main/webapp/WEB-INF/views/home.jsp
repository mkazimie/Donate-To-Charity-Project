<%--
  Created by IntelliJ IDEA.
  User: magdalena
  Date: 25.06.2020
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <header class="header--main-page">
        <%@ include file="header-after-login.jsp" %>

    <%--        <nav class="container container--70">--%>
<%--            <ul class="nav--actions">--%>
<%--                <form action="<c:url value="/logout"/>" method="post">--%>
<%--                    <li><input type="submit" class="btn btn--small btn--without-border" value="Wyloguj"/></li>--%>
<%--                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--                </form>--%>

<%--&lt;%&ndash;                TODO: add link to user profile modification&ndash;%&gt;--%>
<%--                <li><a class="btn btn--small btn--without-border" href="#"><i--%>
<%--                        class="fas fa-user">${currentUser.name}</i></a></li>--%>
<%--            </ul>--%>

<%--            <ul>--%>
<%--                <li><a href="/" class="btn btn--without-border active">Start</a></li>--%>
<%--                <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>--%>
<%--                <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>--%>
<%--                <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>--%>
<%--                <li><a href="/form" class="btn btn--without-border">Przekaż dary</a></li>--%>
<%--                <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>--%>
<%--            </ul>--%>
<%--        </nav>--%>
    </header>
    <h1> Witaj, użytkowniku </h1>
    <%@ include file="footer.jsp" %>

    <script src="<c:url value="/resources/js/app.js"/>"></script>
</sec:authorize>
</body>
</html>
