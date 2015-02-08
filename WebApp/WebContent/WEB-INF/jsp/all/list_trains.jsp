<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" scope="page" ><fmt:message key = "list_trains_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf" %>

	
			
		
		<form id="listTrains" action="controller" class = "form-signin">
				<legend><fmt:message key = "list_trains_jsp.form.title" /></legend>
				<input type="hidden" name="command" value="listTrains"/>
				<label><fmt:message key = "list_trains_jsp.form.sdate" />:</label><input type="date" name="startDate" class="input-block-level" />
				<label><fmt:message key = "list_trains_jsp.form.edate" />:</label><input type="date" name = "endDate" class="input-block-level" />
				<input type="submit"><fmt:message key = "list_trains_jsp.form.show" /></input>
			</form>

			<div id = "wrap">
			<%-- CONTENT --%>
			<table class = "table">
			<tr>
			<td><fmt:message key = "list_trains_jsp.table.depStation" /></td>
			<td><fmt:message key = "list_trains_jsp.table.depDate" /></td>
			<td><fmt:message key = "list_trains_jsp.table.depTime" /></td>
			<td><fmt:message key = "list_trains_jsp.table.arrStation" /></td>
			<td><fmt:message key = "list_trains_jsp.table.arrDate" /></td>
			<td><fmt:message key = "list_trains_jsp.table.arrTime" /></td>
			</tr>
			<c:forEach var="bean" items="${trainList}">
					<tr>
						<td>${bean.route.departureStation.name} </td>
						<td>${bean.departureDate}</td>
						<td><fmt:formatDate value="${bean.route.departureTime}" pattern="HH:mm:ss" /></td>
						<td>${bean.route.arrivalStation.name}</td>
						<td>${bean.arrivalDate}</td>
						<td><fmt:formatDate value="${bean.route.arrivalTime}" pattern="HH:mm:ss" /></td>
						<td><a href="controller?command=listRouteComposition&routeId=${bean.route.id}"><fmt:message key = "list_trains_jsp.table.info" /></a></td>
						<td><a href="controller?command=listTrainInfo&trainId=${bean.id}"><fmt:message key = "list_trains_jsp.table.buy" /></a></td>
						<c:if test="${userRole.name == 'admin'}">
						<td><a href="controller?command=editTrain&trainId=${bean.id}"><fmt:message key = "list_trains_jsp.table.edit" /></a></td>
						<td><a href="controller?command=deleteTrain&trainId=${bean.id}"><fmt:message key = "list_trains_jsp.table.delete" /></a></td>
						</c:if>
					</tr>

				</c:forEach>			
			</table>
			
			
			
			<%-- CONTENT --%>
		</div>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		

</body>
