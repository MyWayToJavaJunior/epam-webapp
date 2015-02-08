<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" scope="page" ><fmt:message key = "add_train_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<table id="main-container">
			<td class="content">			
			<%-- CONTENT --%>
			
			<c:out value="${message}"/>
			
			<form id="addTrain" action="controller" method = "post">
			
				<input type="hidden" name="command" value="addTrain"/>
				<label><c:set var="title" scope="page" ><fmt:message key = "add_train_jsp.form.route" /></c:set></label>
				<input type="text" name="routeId" /><br>
				<label><c:set var="title" scope="page" ><fmt:message key = "add_train_jsp.form.depDate" /></c:set></label>
				<input type="date" name="departureDate" /><br>
				<label><c:set var="title" scope="page" ><fmt:message key = "add_train_jsp.form.arrDate" /></c:set></label>
				<input type="date" name="arrivalDate" /><br>
				<input type="submit" value = "Add"/>
				
			</form>
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
