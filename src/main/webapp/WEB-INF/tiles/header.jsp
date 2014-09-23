<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <!-- <a class="navbar-brand" href="#">Serwis</a> -->
        <div class="nav-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/ex2">Start</a></li>
                <li><a href='<s:url value="/homeSignedIn"></s:url>'>Moje</a></li>
                <li><a href='<s:url value="/homeNotSignedIn"></s:url>'>Wszystkie</a></li>
                <li><a href='<s:url value="/addnotification"></s:url>'>Dodaj</a></li>
                <li><a href='<s:url value="/addvalue"></s:url>'>Dodaj do słownika</a></li>
                <li><a href='<s:url value="/categoriesList"></s:url>'>Kategorie</a></li>
                <li><a href='<s:url value="/subcategoriesList"></s:url>'>Podkategorie</a></li>
                <li><a href='<s:url value="/typesList"></s:url>'>Typy</a></li>
                <li><a href='<s:url value="/prioritiesList"></s:url>'>Priorytety</a></li>
                <li><a href='<s:url value="/statusesList"></s:url>'>Statusy</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
            <li><a href='<s:url value="/signup"></s:url>'>Zarejestruj</a></li>
                <security:authorize access="!isAuthenticated()">
                    <li><a href='<s:url value="/signin"></s:url>'>Zaloguj</a></li>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <li><a href='<s:url value="/logout"></s:url>'>Wyloguj (<security:authentication property="principal.username"/>)</a></li>
                </security:authorize>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>