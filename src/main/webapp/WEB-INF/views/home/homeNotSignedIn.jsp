<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="hero-unit">
   <!--   <h1><s:message code="view.index.title" /></h1> -->
    <h2 align="center">
        Witamy w serwisie.
    </h2> 
</div>
<html>	
	<div>
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
	</tr>
	<c:forEach items="${notificationList}" var="notification">
					<tr   >
						<td>${notification.id}</td>
						<td>${notification.name}</td>
						<td>${notification.shortDescription}</td>
						<td>${notification.category_id.name}</td>
						<td>${notification.subcategory_id.name}</td>
						<td>${notification.type_id.name}</td>
						<td>${notification.status_id.name}</td>
						<td>${notification.priority_id.name}</td>
						<td>${notification.user.label}</td>
					</tr>
	</c:forEach>
	</table>
	</div>
</html>