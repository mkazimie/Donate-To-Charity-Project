<%@ page pageEncoding="UTF-8" %>

    <ul class="nav--actions">
        <c:choose>
            <c:when test="${empty currentUser}">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </c:when>
            <c:otherwise>
                <form action="<c:url value="/logout"/>" method="post">
                    <li><input type="submit" class="btn btn--small btn--without-border" value="Wyloguj"/></li>
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
            </c:otherwise>
        </c:choose>
    </ul>

