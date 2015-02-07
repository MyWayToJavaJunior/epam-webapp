<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Routes" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

			
		
			


<!-- 			<form id="listTrains" action="controller"> -->
<!-- 				<input type="hidden" name="command" value="listTrains"/> -->
<!-- 				<input type="date" name="startDate" /> -->
<!-- 				<input type="date" name = "endDate" /> -->
<!-- 				<input type="submit" value = "Show"/> -->
<!-- 			</form> -->
			

			<div id = "wrap">		
			<%-- CONTENT --%>
			<table class = "table">
			<tr>
						<td>Departure station: </td>
						<td>Departure time:</td>
						<td>Arrival station:</td>
						<td>Arrival time:</td>
<%-- 						<td><a href="controller?command=listRouteComposition&routeId=${bean.id}">Info</a></td> --%>
<%-- 						<c:if test="${userRole.name == 'admin'}"> --%>
<%-- 						<td><a href="controller?command=editRoute&routeId=${bean.id}">Edit</a></td> --%>
<%-- 						<td><a href="controller?command=deleteRoute&routeId=${bean.id}">Delete</a></td> --%>
<%-- 						</c:if> --%>
			</tr>
			<c:forEach var="bean" items="${routesList}">
					
					<tr>
						<td>${bean.departureStation.name} </td>
						<td><fmt:formatDate value="${bean.departureTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.arrivalStation.name}</td>
						<td><fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td><a href="controller?command=listRouteComposition&routeId=${bean.id}">Info</a></td>
						<c:if test="${userRole.name == 'admin'}">
						<td><a href="controller?command=editRoute&routeId=${bean.id}">Edit</a></td>
						<td><a href="controller?command=deleteRoute&routeId=${bean.id}">Delete</a></td>
						</c:if>
					</tr>

				</c:forEach>			
			</table>
			
			
			
			<%-- CONTENT --%>
			</div>

		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		

</body>
