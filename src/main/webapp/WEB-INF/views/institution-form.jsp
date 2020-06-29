<%--
  Created by IntelliJ IDEA.
  User: magdalena
  Date: 28.06.2020
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
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
<header class="header--form-page">
    <%@ include file="header-after-login.jsp" %>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <section class="login-page">
                <form:form method="post" modelAttribute="institution" action="/admin/institutions/form">
                    <h2>Wypełnij Formularz</h2>

                    <div class="form-group">
                        <div class="failed"><form:errors path="name"/></div>
                        <form:input path="name" placeholder="Nazwa"/>
                    </div>
                    <div class="form-group">
                        <div class="failed"><form:errors path="name"/></div>
                        <form:textarea path="description" placeholder="Opis"/>
                    </div>

                    <div class="form-group form-group--buttons">
                        <input type="submit" class="btn btn--without-border" value="Zapisz">
                        <a href="/admin/institutions/" class="btn btn--without-border">Cofnij</a>
                    </div>
                    <form:hidden path="id"/>
                </form:form>

            </section>
        </div>
    </div>




</header>


</body>
</html>
