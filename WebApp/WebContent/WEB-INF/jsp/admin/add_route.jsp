<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>


<html>

<c:set var="title" scope="page">
	<fmt:message key="add_route_jsp.title" />
</c:set>
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<%-- CONTENT --%>
	<div id="wrap">
		<c:out value="${message}" />

		<form id="addRoute" action="controller" method="post" class = "form-signin">

			<input type="hidden" name="command" value="addRoute" />
			<label><fmt:message key="add_route_jsp.form.depStation" />
			:</label>
			<my:stations name="departureStationId" />
			<br>
			<label><fmt:message key="add_route_jsp.form..depTime" />
			:</label><input type="time" name="departureTime" /><br>
			<label><fmt:message key="add_route_jsp.form.arrStation" />
			:</label>
			<my:stations name="arrivalStationId" />
			<br>
			<label><fmt:message key="add_route_jsp.form.arrTime" />
			:</label><input type="time" name="arrivalTime" /><br> <input
				type="submit" value="Add" /><br>
		</form>


		<%-- CONTENT --%>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>


</body>