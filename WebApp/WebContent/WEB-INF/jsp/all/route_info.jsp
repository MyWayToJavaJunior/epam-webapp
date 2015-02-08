<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" scope="page">
	<fmt:message key="route_info_jsp.title" />
</c:set>
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>



	<!-- 			<form id="listTrains" action="controller"> -->
	<!-- 				<input type="hidden" name="command" value="listTrains"/> -->
	<!-- 				<input type="date" name="startDate" /> -->
	<!-- 				<input type="date" name = "endDate" /> -->
	<!-- 				<input type="submit" value = "Show"/> -->
	<!-- 			</form> -->


	<%-- CONTENT --%>

	<div id="wrap">
		<fmt:message key="route_info_jsp.depStation" />
		: ${route.departureStation.name}<br>
		<fmt:message key="route_info_jsp.depTime" />
		:
		<fmt:formatDate value="${route.departureTime}" pattern="HH:mm:ss" />
		<br>
		<fmt:message key="route_info_jsp.arrStation" />
		: ${route.arrivalStation.name}<br>
		<fmt:message key="route_info_jsp.arrTime" />
		:
		<fmt:formatDate value="${route.arrivalTime}" pattern="HH:mm:ss" />
		<br>
		<table class="table table-bordered">
			<tr>
				<td><fmt:message key="route_info_jsp.table.station" /></td>
				<td><fmt:message key="route_info_jsp.table.arrTime" /></td>
				<td><fmt:message key="route_info_jsp.table.stay" /></td>
				<td><fmt:message key="route_info_jsp.table.depTime" /></td>
			</tr>
			<c:forEach var="bean" items="${route.routeComposition}">
				<tr>
					<td>${bean.station.name}</td>
					<td><fmt:formatDate value="${bean.arrivalTime}"
							pattern="HH:mm:ss" /></td>
					<td>${bean.stay}m</td>
					<td><fmt:formatDate value="${bean.departureTime}"
							pattern="HH:mm:ss" /></td>
					<c:if test="${userRole.name == 'admin'}">
						<td><a
							href="controller?command=deleteRouteComposition&routeCompositionId=${bean.id}&routeId=${route.id}"><td><fmt:message
										key="route_info_jsp.table.delete" /></td></a></td>
					</c:if>
				</tr>

			</c:forEach>
		</table>

		<fmt:formatDate value="${bean.arrivalTime}" pattern="HH:mm:ss" />
		<br> <br>
		<c:if test="${userRole.name == 'admin'}">
			<form id="addRouteComposition" class="form-signin"
				action="controller" method="post">
				<fieldset>
					<input type="hidden" name="command" value="addRouteComposition" />
					<input type="hidden" name="routeId" value="${route.id}" /> <label>Station:</label>
					<my:stations name="stationId" />
					<br> <label>Arrival time:</label><input type="time"
						name="arrivalTime" /><br> <label>Departure time:</label><input
						type="time" name="departureTime" /><br> <label>Stay
						time:</label><input type="text" name="stay" /><br> <input
						type="submit" value="Add" /><br>
				</fieldset>
			</form>
		</c:if>
	</div>