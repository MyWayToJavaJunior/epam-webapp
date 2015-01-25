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
			
			
			Departure station: ${route.departureStation.name}
			<fmt:formatDate value="${route.departureTime}" pattern="HH:mm:ss" />
			<c:forEach var="bean" items="${route.routeComposition}">
					<tr>
						<td>${bean.station.name} </td>
						<td><fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.stay}m</td>
						<td><fmt:formatDate value="${bean.departureTime}" pattern="HH:mm:ss" /></td>
					</tr>
				</c:forEach>	
			Arrival station: ${route.arrivalStation.name}
			<fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" />
			
			
			