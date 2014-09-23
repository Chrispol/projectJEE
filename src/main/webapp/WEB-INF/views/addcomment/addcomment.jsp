<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>


<form:form class="form-narrow form-horizontal" method="post" modelAttribute="commentForm">

    <fieldset>
     <legend>Dodaj komentarz</legend>     
             <div class="form-group">
            <label for="notificationId" class="col-lg-2 control-label">Id zgloszenia</label>
            <div class="col-lg-10">
                <form:input path="notificationId" class="form-control" id="notificationId" maxlength="120"/>
            </div>
        </div>
    
         <div class="form-group">
            <label for="content" class="col-lg-2 control-label">Komentarz</label>
                <form:textarea path="content" class="form-control" id="content" maxlength="150" size="250"/>
                <form:errors path="content" element="span" class="help-block"/>
                <button type="submit" class="btn btn-default">Dodaj</button>
        </div>         
    </fieldset>
</form:form>