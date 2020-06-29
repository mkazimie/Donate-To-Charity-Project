<%--
  Created by IntelliJ IDEA.
  User: magdalena
  Date: 28.06.2020
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>

</head>
<body>
<header>
    <%@ include file="header-after-login.jsp" %>
</header>
<div class="container mt-5 mx-auto ml-4 mr-4">


    <div class="text-center"><a href="/admin/institutions/form" class="btn btn-warning">Dodaj Fundację</a></div>


    <section class="login-page">
        <h2>Lista Fundacji</h2>
    </section>

    <table class="table table-striped css-serial">
        <thead class="thead-dark">
        <tr class="text-center">
            <th>#</th>
            <th scope="col"> Nazwa Fundacji</th>
            <th scope="col"> Opis</th>
            <th scope="col"> Zarządzaj</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${institutions}" var="institution">
            <tr class="text-center">
                <td class="align-middle"></td>
                <td class="align-middle"><strong>${institution.name}</strong></td>
                <td class="align-middle">${institution.description}</td>
                <td class="align-middle"><a href="/admin/institutions/update/${institution.id}"> Edytuj </a> |
                    <a href="/admin/institutions/confirm-delete/${institution.id}"> Usuń </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>



</div>

</body>
</html>
