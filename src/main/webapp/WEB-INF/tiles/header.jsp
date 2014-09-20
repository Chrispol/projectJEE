<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
                <li class="active"><a href="#">Strona główna</a></li>
                <li><a href='<s:url value="/addnotification"></s:url>'>Dodaj zgłoszenie</a></li>
                <li><a href='<s:url value="/addvalue"></s:url>'>Wartość słownikowa</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
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