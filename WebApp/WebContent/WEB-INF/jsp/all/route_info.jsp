<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Routes" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<table id="main-container">
			
			
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
			
			
			Departure station: ${route.departureStation.name}<br>
			Departure time: <fmt:formatDate value="${route.departureTime}" pattern="HH:mm:ss" /><br>
			Arrival station: ${route.arrivalStation.name}<br>
			Arrival time :<fmt:formatDate value="${route.arrivalTime}" pattern="HH:mm:ss" /><br>
			<c:forEach var="bean" items="${route.routeComposition}">
					<tr>
						<td>${bean.station.name} </td>
						<td><fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.stay}m</td>
						<td><fmt:formatDate value="${bean.departureTime}" pattern="HH:mm:ss" /></td>
						<c:if test="${userRole.name == 'admin'}">
							<td><a href="controller?command=deleteRouteComposition&routeCompositionId=${bean.id}&routeId=${route.id}">Delete</a></td>
						</c:if>
					</tr>
				</c:forEach>	
			
			<fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" />
			<br>
			<br>
			<c:if test="${userRole.name == 'admin'}">
					<form id="addRouteComposition" action="controller" method = "post">
				
				<input type="hidden" name="command" value="addRouteComposition"/>
				<input type="hidden" name="routeId" value="${route.id}"/>
				Station:<my:stations name = "stationId"/><br>
				Arrival time:<input type="time" name="arrivalTime" /><br>
				Departure time:<input type="time" name="departureTime" /><br>
				Stay time:<input type="text" name="stay" /><br>
				
				<input type="submit" value = "Add"/><br>
	</form>
			</c:if>
			
			
			