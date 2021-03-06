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


<script type="text/javascript">
$(document).ready(
			function() {
				if($('#categories').val() != '-1'){
					$.getJSON('${findSubcategoriesByCategory}', {
						categoryName : $('#categories').val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="-1">Wybierz podkategorie</option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '" ';
							
							if(data[i].id == $('#oldSubcategory').val()) html+='selected';		
							
							html+=' >'
									+ data[i].name + '</option>';
						}
						$('#subcategories').html(html);
					});
				}
				
				if($('#oldSubcategory').val() != '-1'){
					$.getJSON('${findTypes}', {
						subcategoryId : $('#oldSubcategory').val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="-1">Wybierz typ</option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '" ';
							
							if(data[i].id == $('#oldType').val()) html+='selected';		
							
							html+=' >'
									+ data[i].name + '</option>';
									
						}
						$('#types').html(html);
					});
					
				}
				
				
			});
</script>



<form:form class="form-horizontal" method="post" modelAttribute="notificationForm">

    <fieldset >
        <legend>Wyszukiwarka zgloszen</legend>
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
				<form:select path="priority" >
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
            <label for="user" class="col-lg-2 control-label">Użytkownik</label>
            <div class="col-lg-10">
				<form:select path="user">
				<form:option value="-1">Wybierz uzytkownika</form:option>
				<form:options items="${selectallusers}" itemValue="id" itemLabel="label"/>
				</form:select>
            </div>
        </div> 
        <form:input path="oldType"  style="visibility:hidden" id="oldType" maxlength="120"/>
        <form:input path="oldSubcategory" style="visibility:hidden" id="oldSubcategory" maxlength="120"/>
        
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Szukaj</button>
            </div>
        </div>
	<div class="form-group">
	<table border="1" style=" border: double; width: 100%">
	<tr>
		<th>Id</th>
		<th>Nazwa</th>
		<th>Opis</th>
		<th>Kategoria</th>
		<th>Podkategoria</th>
		<th>Typ</th>
		<th>Status</th>
		<th>Priorytet</th>
		<th>Uzytkownik</th>
		<th width="15%">Akcja</th>
		<th width="15%">Akcja</th>
	</tr>
	<c:forEach items="${notificationForm.searchNotifications}"  var="notification">
					<tr >
						<td>${notification.id}</td>
						<td>${notification.name}</td>
						<td>${notification.shortDescription}</td>
						<td>${notification.category_id.name}</td>
						<td>${notification.subcategory_id.name}</td>
						<td>${notification.type_id.name}</td>
						<td>${notification.status_id.name}</td>
						<td>${notification.priority_id.name}</td>
						<td>${notification.user.label}</td>
						<td width="15%">
							<form action="shownotification" method="get">
								<input type="submit" value="Szególy" />						
								<input style="visibility:hidden" type="text" name="id"  value ="${notification.id}" />
							</form>												
						</td>
						<td width="15%">
							<form action="addcomment" method="get">
								<input type="submit" value="Dodaj komentarz" />						
								<input style="visibility:hidden" type="text" name="id"  value ="${notification.id}" />
							</form>												
						</td>
					</tr>
	</c:forEach>
	</table>
	</div>
        
    </fieldset>
</form:form>





