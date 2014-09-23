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
        <legend>Szczególy zgloszenia</legend>
        <form:errors path="" element="p" class="text-error"/>
         <div class="form-group">
            <label for="notificationId" class="col-lg-2 control-label">Id</label>
            <div class="col-lg-10">
                <form:input path="notificationDetails.id" class="form-control" id="notificationId" maxlength="120"/>
            </div>
        </div>
         <div class="form-group">
            <label for="name" class="col-lg-2 control-label">Nazwa</label>
            <div class="col-lg-10">
                <form:input path="notificationDetails.name" class="form-control" id="name" maxlength="120"/>
            </div>
        </div>
          <div class="form-group">
            <label for="priority" class="col-lg-2 control-label">Priorytet</label>
            <div class="col-lg-10">
				<form:select path="notificationDetails.priority_id" >
				<form:option value="-1">Wybierz priorytet</form:option>
				<form:options items="${selectpriority}" itemValue="id" itemLabel="name"/>
				</form:select>
            </div>
        </div>   
         <div class="form-group">
            <label for="category" class="col-lg-2 control-label">Kategoria</label>
            <div class="col-lg-10">
				<form:select id="categories"  path="notificationDetails.category_id">
				<form:option value="-1">Wybierz kategorie</form:option>
				<form:options items="${selectcategory}" itemValue="id" itemLabel="name"/>
				</form:select>
            </div>
        </div> 
         <div class="form-group">
            <label for="subcategory" class="col-lg-2 control-label">Podkategria</label>
            <div class="col-lg-10">
				<form:select id="subcategories" path="notificationDetails.subcategory_id">
				<form:option value="-1">Wybierz podkategorie</form:option>
				</form:select>
            </div>
        </div>
      	<div class="form-group">
            <label for="type" class="col-lg-2 control-label">Typ</label>
            <div class="col-lg-10">
				<form:select id="types" path="notificationDetails.type_id">
				<form:option value="-1">Wybierz typ</form:option>
				</form:select>
            </div>
        </div>
         <div class="form-group">
            <label for="status" class="col-lg-2 control-label">Status</label>
            <div class="col-lg-10">
				<form:select path="notificationDetails.status_id">
				<form:option value="-1">Wybierz status</form:option>
				<form:options items="${selectstatus}" itemValue="id" itemLabel="name"/>
				</form:select>
            </div>
        </div>          
         <div class="form-group">
            <label for="user" class="col-lg-2 control-label">Użytkownik</label>
            <div class="col-lg-10">
				<form:select path="notificationDetails.user">
				<form:option value="-1">Wybierz uzytkownika</form:option>
				<form:options items="${selectallusers}" itemValue="id" itemLabel="label"/>
				</form:select>
            </div>
        </div> 
        <form:input path="oldType"  style="visibility:hidden" id="oldType" maxlength="120"/>
        <form:input path="oldSubcategory" style="visibility:hidden" id="oldSubcategory" maxlength="120"/>
        
        <legend>Lista komentarzy</legend>        
	<div class="form-group">
	<table border="1" style=" border: double; width: 100%">
	<tr>
		<th>Id</th>
		<th>Komentarz</th>
		<th>Data utworzenia</th>
		<th>Uzytkownik</th>
	</tr>
	<c:forEach items="${notificationForm.commentList}"  var="comment">
					<tr>
						<td>${comment.id}</td>
						<td>${comment.content}</td>
						<td>${comment.date}</td>
						<td>${comment.user.label}</td>
					</tr>
	</c:forEach>
	</table>
	</div>
        
    </fieldset>
</form:form>





