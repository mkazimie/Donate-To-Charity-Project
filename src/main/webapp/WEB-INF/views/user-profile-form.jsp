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
                <form:form method="post" modelAttribute="user" action="/user/update">
                    <h2>Twoje dane:</h2>
<%--                    <h3 class="failed"> ${failed} </h3>--%>
                    <div class="form-group">
                        <div class="failed"><form:errors path="name"/></div>
                        <form:input path="name"/>
                    </div>
                    <div class="form-group">
                        <div class="failed"><form:errors path="lastName"/></div>
                        <form:input path="lastName"/>
                    </div>
                    <div class="form-group">
                        <div class="failed"><form:errors path="email"/></div>
                        <div class="failed"> ${emailExistsError}</div>
                        <form:input path="email"/>
                    </div>
                    <div class="form-group">
                        <div class="failed"><form:errors path="password"/></div>
                        <div class="failed"> ${passwordToLong}</div>
                        <form:password path="password"/>
                    </div>

                    <div class="form-group form-group--buttons">
                        <input type="submit" class="btn btn--without-border" value="Zapisz">
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="/admin/home" class="btn btn--without-border">Cofnij</a>
                        </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                            <a href="/user/home" class="btn btn--without-border">Cofnij</a>
                        </sec:authorize>
                    </div>
                    <form:hidden path="id"/>
                    <form:hidden path="roles"/>
                    <form:hidden path="enabled"/>
                </form:form>

            </section>
        </div>
    </div>




</header>


</body>
</html>
