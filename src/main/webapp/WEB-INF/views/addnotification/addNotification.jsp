<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form class="form-narrow form-horizontal" method="post" modelAttribute="notificationForm">

    <fieldset>
        <legend>Dodaj zgłoszenie</legend>
        <form:errors path="" element="p" class="text-error"/>
         <div class="form-group">
            <label for="name" class="col-lg-2 control-label">Nazwa</label>
            <div class="col-lg-10">
                <form:input path="name" class="form-control" id="name" maxlength="120"/>
                <form:errors path="name" element="span" class="help-block"/>
            </div>
        </div>
<%--         <div class="form-group">
            <label for="priority" class="col-lg-2 control-label">Priorytet</label>
            <div class="col-lg-10">
                <form:select path="priority" class="form-control" cssErrorClass="form-control" id="priority"/>
                <form:errors path="priority" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="category" class="col-lg-2 control-label">Kategoria</label>
            <div class="col-lg-10">
                <form:input path="category" class="form-control" cssErrorClass="form-control" id="category"/>
                <form:errors path="category" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="subcategory" class="col-lg-2 control-label">Podkategoria</label>
            <div class="col-lg-10">
                <form:input path="subcategory" class="form-control" cssErrorClass="form-control" id="subcategory"/>
                <form:errors path="subcategory" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="type" class="col-lg-2 control-label">Typ</label>
            <div class="col-lg-10">
                <form:input path="type" class="form-control" cssErrorClass="form-control" id="type"/>
                <form:errors path="type" element="span" class="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <label for="status" class="col-lg-2 control-label">Status</label>
            <div class="col-lg-10">
                <form:input path="status" class="form-control" cssErrorClass="form-control" id="status"/>
                <form:errors path="status" element="span" class="help-block"/>
            </div>
        </div> --%>
        <div class="form-group">
            <label for="shortDescription" class="col-lg-2 control-label">Opis:</label>
            <div class="col-lg-10">
                <form:textarea path="shortDescription" class="form-control" cssErrorClass="form-control" id="shortDescription" maxlength="300"/>
                <form:errors path="shortDescription" element="span" class="help-block"/>
            </div>
        </div>
<%--          <div class="form-group">
            <label for="user" class="col-lg-2 control-label">Użytkownik</label>
            <div class="col-lg-10">
                <form:textarea path="user" class="form-control" cssErrorClass="form-control" id="user"/>
                <form:errors path="user" element="span" class="help-block"/>
            </div>
        </div> --%>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Dodaj</button>
            </div>
        </div>
    </fieldset>
</form:form>
