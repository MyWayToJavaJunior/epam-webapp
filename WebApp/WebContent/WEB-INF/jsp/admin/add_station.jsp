<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add station</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<%-- 	<c:if test="${not empty message}"> --%>
	<%= request.getParameter("message") %>
<%-- 	</c:if> --%>

	<form id="addStation" action="controller" method = "post">
				
				<input type="hidden" name="command" value="addStation"/>
				<label>Station name</label><input type="text" name="stationName" />
				<input type="submit" value = "Add"/>
	</form>

	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	
	
</body>
</html>