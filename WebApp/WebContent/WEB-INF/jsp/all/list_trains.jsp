<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Trains" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf" %>

	
			
		
		<form id="listTrains" action="controller" class = "form-signin">
				<legend>Choose train date</legend>
				<input type="hidden" name="command" value="listTrains"/>
				<label>Start date:</label><input type="date" name="startDate" class="input-block-level" />
				<label>End date:</label><input type="date" name = "endDate" class="input-block-level" />
				<input type="submit" value = "Show"/>
			</form>

			<div id = "wrap">
			<%-- CONTENT --%>
			<table class = "table">
			<c:forEach var="bean" items="${trainList}">
					<tr>
						<td>${bean.route.departureStation.name} </td>
						<td>${bean.departureDate}</td>
						<td><fmt:formatDate value="${bean.route.departureTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.route.arrivalStation.name}</td>
						<td>${bean.arrivalDate}</td>
						<td><fmt:formatDate value="${bean.route.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td><a href="controller?command=listRouteComposition&routeId=${bean.route.id}">Info</a></td>
						<td><a href="controller?command=listTrainInfo&trainId=${bean.id}">Buy ticket</a></td>
						<c:if test="${userRole.name == 'admin'}">
						<td><a href="controller?command=editTrain&trainId=${bean.id}">Edit</a></td>
						<td><a href="controller?command=deleteTrain&trainId=${bean.id}">Delete</a></td>
						</c:if>
					</tr>

				</c:forEach>			
			</table>
			
			
			
			<%-- CONTENT --%>
		</div>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		

</body>
