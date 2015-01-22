<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<c:when test="${message != null }">
			<c:out value=${message}/>
		</c:when>

	<form id="listTrains" action="controller">
				<input type="hidden" name="command" value="addStation"/>
				<input type="text" name="stationName" />
				<input type="submit" value = "Add"/>
	</form>
	
	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
	
	
</body>
</html>