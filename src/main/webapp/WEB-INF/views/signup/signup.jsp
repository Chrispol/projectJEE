<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form class="form-narrow form-horizontal" method="post" modelAttribute="signupForm">

    <fieldset>
        <legend>Rejestracja</legend>
        <form:errors path="" element="p" class="text-error"/>
        <div class="form-group">
            <label for="email" class="col-lg-2 control-label">Email</label>
            <div class="col-lg-10">
                <form:input path="email" class="form-control" cssErrorClass="form-control" id="email" placeholder="Email address" maxlength="64"/>
                <form:errors path="email" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-lg-2 control-label">Hasło</label>
            <div class="col-lg-10">
                <form:password path="password" class="form-control" id="password" placeholder="Password" maxlength="20"/>
                <form:errors path="password" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-lg-2 control-label">Imię</label>
            <div class="col-lg-10">
                <form:input path="name" class="form-control" cssErrorClass="form-control" id="name" placeholder="Name" maxlength="25"/>
                <form:errors path="name" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="surname" class="col-lg-2 control-label">Nazwisko</label>
            <div class="col-lg-10">
                <form:input path="surname" class="form-control" cssErrorClass="form-control" id="surname" placeholder="Surname" maxlength="25"/>
                <form:errors path="surname" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="phoneNumber" class="col-lg-2 control-label">Telefon</label>
            <div class="col-lg-10">
                <form:input path="phoneNumber" class="form-control" cssErrorClass="form-control" id="phoneNumber" placeholder="Phone Number" maxlength="13"/>
                <form:errors path="phoneNumber" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Załóż konto</button>
            </div>
        </div>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <p>Masz już konto? <a href='<s:url value="/signin"/>'>Zaloguj się</a></p>
            </div>
        </div>
    </fieldset>
</form:form>
