<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Trains" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">
			
		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
		<td>
			<form id="listTrains" action="controller">
				<input type="hidden" name="command" value="listTrains"/>
				<input type="date" name="startDate" />
				<input type="date" name = "endDate" />
				<input type="submit" value = "Show"/>
			</form>
			
		</td>
			<td class="content">			
			<%-- CONTENT --%>
			
			<c:forEach var="bean" items="${trainList}">
					<tr>
						<td>${bean.route.departureStation.name} </td>
						<td>${bean.departureDate}</td>
						<td><fmt:formatDate value="${bean.route.departureTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.route.arrivalStation.name}</td>
						<td>${bean.arrivalDate}</td>
						<td><fmt:formatDate value="${bean.route.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td><a href="controller?command=ListRouteInfo&routeId=${bean.route.id}">Info</a><</td>
					</tr>

				</c:forEach>			
			
			
			
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
