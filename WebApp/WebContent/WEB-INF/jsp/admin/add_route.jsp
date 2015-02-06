<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Routes" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<table id="main-container">
			<td class="content">			
			<%-- CONTENT --%>
			
			<c:out value="${message}"/>
			
			<form id="editRoute" action="controller" method = "post">
				
				<input type="hidden" name="command" value="addRoute"/>
				Departure station:<input type="text" name="departureStationId" /><br>
				Departure time:<input type="time" name="departureTime" /><br>
				Arrival station:<input type="text" name="arrivalStationId" /><br>
				Arrival time:<input type="time" name="arrivalTime" /><br>
				<input type="submit" value = "Add"/><br>
	</form>
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
