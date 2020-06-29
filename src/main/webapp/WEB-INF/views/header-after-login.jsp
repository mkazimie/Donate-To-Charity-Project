<%--
  Created by IntelliJ IDEA.
  User: magdalena
  Date: 29.06.2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="container container--70">
    <ul class="nav--actions">
        <form action="<c:url value="/logout"/>" method="post">
            <input type="submit" class="btn btn--small btn--without-border" value="Wyloguj"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <sec:authorize access="hasRole('ADMIN')">
            <li><a class="btn btn--small btn--without-border" href="/admin/home"><i
                    class="fas fa-home">${currentUser.name}</i></a></li>
        </sec:authorize>
        <sec:authorize access="hasRole('USER')">
            <li><a class="btn btn--small btn--without-border" href="/user/home"><i
                    class="fas fa-home">${currentUser.name}</i></a></li>
        </sec:authorize>
    </ul>

    <sec:authorize access="isAuthenticated()">
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="/admin/institutions/" class="btn btn--without-border">Fundacje i organizacje</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="#/admin/users/" class="btn btn--without-border">Zarządzaj Użytkownikami</a></li>
            </sec:authorize>
            <li><a href="/form" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="/#myDonations" class="btn btn--without-border">Dary przekazane</a></li>
            <li><a href="/user/update" class="btn btn--without-border">Twój Profil</a></li>
            <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </sec:authorize>

</nav>
