<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Routes" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">
			
		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
		<td>
<!-- 			<form id="listTrains" action="controller"> -->
<!-- 				<input type="hidden" name="command" value="listTrains"/> -->
<!-- 				<input type="date" name="startDate" /> -->
<!-- 				<input type="date" name = "endDate" /> -->
<!-- 				<input type="submit" value = "Show"/> -->
<!-- 			</form> -->
			
		</td>
			<td class="content">			
			<%-- CONTENT --%>
			
			<c:forEach var="bean" items="${routesList}">
					<tr>
						<td>${bean.departureStation.name} </td>
						<td><fmt:formatDate value="${bean.departureTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.arrivalStation.name}</td>
						<td><fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td><a href="controller?command=ListRouteInfo&routeId=${bean.id}">Info</a><</td>
					</tr>

				</c:forEach>			
			
			
			
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
