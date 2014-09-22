<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" %>


		<legend>Typy</legend>
	
	<div>
	<table border="1" style=" border: double; width: 100%">
	<tr>
						<th>Id</th>
						<th >Nazwa</th>
						<th >Akcja</th>
						<th >Akcja</th>
	</tr>
	<c:forEach items="${typeList}" var="category">
					<tr>
						<td><b>${category.id}</b></td>
						<td >${category.name}</td>
						<td >
							<form action="editvalue" method="get">
								<input type="submit" value="Edytuj" >						
								<input style="visibility:hidden" type="text" name="id"  value ="${category.id}" >
							</form>						
						</td>
						<td >
							<form action="delvalue" method="post">
								<input type="submit" value="Usun" >						
								<input style="visibility:hidden" type="text" name="categoryId"  value ="${category.id}" >
							</form>						
						</td>
					</tr>
	</c:forEach>
	
		</table>
	</div>
	<br/>
	