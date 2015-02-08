<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" scope="page" ><fmt:message key = "add_train_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<div id = "wrap">
<%@ include file="/WEB-INF/jspf/header.jspf" %>		
			<%-- CONTENT --%>
			
			<c:out value="${message}"/>
			
			<form id="addTrain" action="controller" method = "post" class = "form-signin">
			
				<input type="hidden" name="command" value="addTrain"/>
				<label><fmt:message key = "add_train_jsp.form.route" /></label>
				<input type="text" name="routeId" /><br>
				<label><fmt:message key = "add_train_jsp.form.depDate" /></label>
				<input type="date" name="departureDate" /><br>
				<label><fmt:message key = "add_train_jsp.form.arrDate" /></label>
				<input type="date" name="arrivalDate" /><br>
				<input type="submit" value = "Add"/>
				
			</form>
			
			<%-- CONTENT --%>
		</div>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
</body>
