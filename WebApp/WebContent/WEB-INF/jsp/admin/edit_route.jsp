<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="title" scope="page">
	<fmt:message key="edit_route_jsp.title" />
</c:set>
<head>
<title>Add station</title>
</head>
<body>
	<%@ include file="/WEB-INF/jspf/header.jspf"%>



	<form id="editRoute" action="controller" method="post">

		<input type="hidden" name="command" value="editRoute" /> 
		<input	type="hidden" name="routeId" value="${param.routeId}" /> 
			<label><fmt:message
				key="edit_route_jsp.form.depStation" /> :</label>
		<my:stations name="departureStationId" />
		<br> <label><fmt:message key="edit_route_jsp.form.depTime" />
			:</label><input type="time" name="departureTime" /><br> <label><fmt:message
				key="edit_route_jsp.form.arrStation" /> :</label>
		<my:stations name="arrivalStationId" />
		<br> <label><fmt:message key="edit_route_jsp.form.arrTime" />
			:</label><input type="time" name="arrivalTime" /><br> <input
			type="submit" value="Edit" /><br>
	</form>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>


</body>
</html>