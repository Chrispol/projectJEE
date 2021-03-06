<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>


<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery-1.6.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-ui/jquery-ui-1.8.10.custom.min.js" />"></script>	

<c:url var="findSubcategoriesByCategory" value="/subcategories" />
<c:url var="findCategories" value="/categories" />



<script type="text/javascript">
$(document).ready(function() {
	$('#categories').change(
			function() {
				if($('#dictionaries').val() == 'TYPE'){
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
				}
			});
});
</script>

<script type="text/javascript">
$(document).ready(
			function() {
				if($('#dictionaries').val() == 'SUBCATEGORY' || $('#dictionaries').val() == 'TYPE'){
					$.getJSON('${findCategories}', {
						ajax : 'true'
					}, function(data) {
						var html = '';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '" ';
							
							if(data[i].id == $('#oldCategory').val()) html+='selected';		
							
							html+=' >'
									+ data[i].name + '</option>';
									
						}
						$('#categories').html(html);
					});
					
					$("#categoryId").css("visibility","visible")
				}else{
					$("#categoryId").css("visibility","hidden")					
				}
				if($('#dictionaries').val() == 'TYPE'){
					$.getJSON('${findSubcategoriesByCategory}', {
						categoryName : $('#oldCategory').val(),
						ajax : 'true'
					}, function(data) {
						var html = '';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].id + '" ';
							
							if(data[i].id == $('#oldSubcategory').val()) html+='selected';		
							
							html+=' >'
									+ data[i].name + '</option>';
						}
						$('#subcategories').html(html);
					});
					$("#subcategoryId").css("visibility","visible")
				}else{
					$("#subcategoryId").css("visibility","hidden")					
				}
				
			});
</script>



	
<form:form class="form-narrow form-horizontal" method="post" modelAttribute="dictionaryForm">

    <fieldset>
        <legend>Aktualizuj wartość słownikową</legend>
        <form:errors path="" element="p" class="text-error"/>
         <div class="form-group">
            <label for="id" class="col-lg-2 control-label">Id</label>
            <div class="col-lg-10">
                <form:input path="id"  id="id" maxlength="120" disabled="true" />
            </div>
        </div>    
         <div class="form-group">
            <label for="name" class="col-lg-2 control-label">Nazwa</label>
            <div class="col-lg-10">
                <form:input path="name" class="form-control" id="name" maxlength="120"/>
                <form:errors path="name" element="span" class="help-block"/>
            </div>
        </div>    
          <div class="form-group">
            <label for="dictionaries" class="col-lg-2 control-label">Typ słownika</label>
            <div class="col-lg-10">
				<form:select id="dictionaries" disabled="true" path="dictionaryType" >
				<form:options items="${dictionaryType}" itemValue="name"  itemLabel="message"/>
				</form:select>
            </div>
        </div> 

          <div id = "categoryId" class="form-group" style="visibility: hidden">
           <label for="categories" class="col-lg-2 control-label">Wybierz kategorie</label>
            <div class="col-lg-10">
				<form:select id="categories" path="category">
				</form:select>
            </div>
          </div> 


          <div id = "subcategoryId" class="form-group" style="visibility: hidden">
            <label for="subcategories" class="col-lg-2 control-label">Wybierz podkategorie</label>
            <div class="col-lg-10">
		       	<form:select id="subcategories" path="subcategory">
				<form:option value="-1">Wybierz podkategorie</form:option>		       	
				</form:select>    
            </div>
        </div> 

        
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Zapisz</button>
            </div>
        </div>
        
        <form:input path="oldCategory"  style="visibility:hidden" id="oldCategory" maxlength="120"/>
        <form:input path="oldSubcategory" style="visibility:hidden" id="oldSubcategory" maxlength="120"/>
        <form:input path="dictionaryTypeString" style="visibility:hidden" id="dictionaryTypeString" maxlength="120"/>
        

        
        
        
    </fieldset>
</form:form>
