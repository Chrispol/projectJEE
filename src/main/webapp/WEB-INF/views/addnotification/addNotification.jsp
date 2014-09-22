<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery-1.6.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-ui/jquery-ui-1.8.10.custom.min.js" />"></script>	

<c:url var="findSubcategoriesByCategory" value="/subcategories" />
<c:url var="findTypes" value="/types" />

<script type="text/javascript">
$(document).ready(function() {
	$('#categories').change(
			function() {
					$.getJSON('${findSubcategoriesByCategory}', {
						categoryName : $(this).val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="-1">Wybierz podkategorie</option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '">'
									+ data[i].name + '</option>';
						}
						$('#subcategories').html(html);
					});
			});
});
</script>

<script type="text/javascript">
$(document).ready(function() {
	$('#subcategories').change(
			function() {
					$.getJSON('${findTypes}', {
						subcategoryId : $(this).val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="-1">Wybierz typ</option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '">'
									+ data[i].name + '</option>';
						}
						$('#types').html(html);
					});
			});
});
</script>



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
				<form:option value="-1">Wybierz priorytet</form:option>
				<form:options items="${selectpriority}" itemValue="id" itemLabel="name"/>
				</form:select>
            </div>
        </div>   
         <div class="form-group">
            <label for="category" class="col-lg-2 control-label">Kategoria</label>
            <div class="col-lg-10">
				<form:select id="categories"  path="category">
				<form:option value="-1">Wybierz kategorie</form:option>
				<form:options items="${selectcategory}" itemValue="id" itemLabel="name"/>
				</form:select>
            </div>
        </div> 
         <div class="form-group">
            <label for="subcategory" class="col-lg-2 control-label">Podkategria</label>
            <div class="col-lg-10">
				<form:select id="subcategories" path="subcategory">
				<form:option value="-1">Wybierz podkategorie</form:option>
				</form:select>
            </div>
        </div>
      	<div class="form-group">
            <label for="type" class="col-lg-2 control-label">Typ</label>
            <div class="col-lg-10">
				<form:select id="types" path="type">
				<form:option value="-1">Wybierz typ</form:option>
				</form:select>
            </div>
        </div>
         <div class="form-group">
            <label for="status" class="col-lg-2 control-label">Status</label>
            <div class="col-lg-10">
				<form:select path="status">
				<form:option value="-1">Wybierz status</form:option>
				<form:options items="${selectstatus}" itemValue="id" itemLabel="name"/>
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
				<form:option value="-1">Wybierz uzytkownika</form:option>
				<form:options items="${selectallusers}" itemValue="id" itemLabel="label"/>
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
