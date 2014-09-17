<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<body>
	<%-- <%! if (true){ %>
	httml
	<%! } else { %>
	html
	<%!} %>

	<%! String name = new String("ala"); %>
	<%=name %> --%>

<!--  
	request
	resposne
	pageContext
	session
	application
	out
	config
	page
	exception
 -->

<c:choose>
	<c:when test="${param.p eq 'a'}">
	p == a
	</c:when>
	<c:otherwise>
		
	</c:otherwise>
</c:choose>

<%-- <c:if test="${}"></c:if> --%>

<c:url value="/resources/kot.jpg" var="kotResource" />

<c:forEach items="${a.getClass().declaredMethods}" var="method">
	<c:out value="${method}" />
</c:forEach>

<img src="${kotResource}" alt="${kotResource}" />
	Hello world!1! <br/>
	<p>Param p: ${param.p}</p>
	<p>Attribute a: ${a.getClass().declaredMethods}</p>
	${b.policz(c,d) }
	<p>Attribute a: ${a.contentLength}</p>
</body>
</html>