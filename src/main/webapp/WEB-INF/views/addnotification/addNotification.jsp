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
          <div class="form-group">
            <label for="priority" class="col-lg-2 control-label">Priorytet</label>
            <div class="col-lg-10">
				<form:select path="priority">
				<form:option value="-"></form:option>
				<form:options items="${selectpriority}" itemValue="name" itemLabel="name"/>
				</form:select>
            </div>
        </div>   
         <div class="form-group">
            <label for="category" class="col-lg-2 control-label">Kategoria</label>
            <div class="col-lg-10">
				<form:select path="category">
				<form:option value="-"></form:option>
				<form:options items="${selectcategory}" itemValue="name" itemLabel="name"/>
				</form:select>
            </div>
        </div> 
         <div class="form-group">
            <label for="subcategory" class="col-lg-2 control-label">Podkategria</label>
            <div class="col-lg-10">
				<form:select path="subcategory">
				<%-- <form:option value="-"></form:option>
				<form:options items="" itemValue="" itemLabel=""/> --%>
				</form:select>
            </div>
        </div>
      	<div class="form-group">
            <label for="type" class="col-lg-2 control-label">Typ</label>
            <div class="col-lg-10">
				<form:select path="type">
				<%-- <form:option value="-"></form:option>
				<form:options items="" itemValue="" itemLabel=""/> --%>
				</form:select>
            </div>
        </div>
         <div class="form-group">
            <label for="status" class="col-lg-2 control-label">Status</label>
            <div class="col-lg-10">
				<form:select path="status">
				<form:option value="-"></form:option>
				<form:options items="${selectstatus}" itemValue="name" itemLabel="name"/>
				</form:select>
            </div>
        </div>          
        <div class="form-group">
            <label for="shortDescription" class="col-lg-2 control-label">Opis:</label>
            <div class="col-lg-10">
                <form:textarea path="shortDescription" class="form-control" cssErrorClass="form-control" id="shortDescription" maxlength="300"/>
                <form:errors path="shortDescription" element="span" class="help-block"/>
            </div>
        </div>
         <div class="form-group">
            <label for="user" class="col-lg-2 control-label">Użytkownik</label>
            <div class="col-lg-10">
				<form:select path="user">
				<form:option value="-"></form:option>
				<form:options items="${selectallusers}" itemValue="label" itemLabel="label"/>
				</form:select>
            </div>
        </div>  
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Dodaj</button>
            </div>
        </div>
    </fieldset>
</form:form>
