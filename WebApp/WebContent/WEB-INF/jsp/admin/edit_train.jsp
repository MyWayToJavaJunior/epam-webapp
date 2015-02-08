<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" scope="page" ><fmt:message key = "edit_train_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<table id="main-container">
			<td class="content">			
			<%-- CONTENT --%>
			
			<c:out value="${message}"/>
			
			<form id="editTrain" action="controller" method = "post">
			
				<input type="hidden" name="command" value="editTrain"/>
				<input type="hidden" name="trainId" value="${param.trainId}"/>
				<label><fmt:message key = "edit_train_jsp.form.route" /></label>
				<input type="text" name="routeId" /><br>
				<label><fmt:message key = "edit_train_jsp.form.depDate" /></label>
				<input type="date" name="departureDate" /><br>
				<label><fmt:message key = "edit_train_jsp.form.arrDate" /></label>
				<input type="date" name="arrivalDate" /><br>
				<input type="submit" value = "Edit"/>
				
			</form>
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
