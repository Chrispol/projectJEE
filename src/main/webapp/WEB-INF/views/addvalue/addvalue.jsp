<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<form:form class="form-narrow form-horizontal" method="post" modelAttribute="dictionaryForm">

    <fieldset>
        <legend>Dodaj wartość słownikową</legend>
        <form:errors path="" element="p" class="text-error"/>
         <div class="form-group">
            <label for="name" class="col-lg-2 control-label">Nazwa</label>
            <div class="col-lg-10">
                <form:input path="name" class="form-control" id="name" maxlength="120"/>
                <form:errors path="name" element="span" class="help-block"/>
            </div>
        </div>    
          <div class="form-group">
            <label for="type" class="col-lg-2 control-label">Typ</label>
            <div class="col-lg-10">
				<form:select path="type">
				<form:option value="-"></form:option>
				<form:options items="${typeList}" itemValue="message" itemLabel="message"/>
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
