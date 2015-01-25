<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	
	<%= request.getParameter("message") %>

	<form id="addStation" action="controller" method = "post">
				
				<input type="hidden" name="command" value="addStation"/>
				<input type="text" name="stationName" />
				<input type="submit" value = "Add"/>
	</form>

	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	
	
</body>
</html>