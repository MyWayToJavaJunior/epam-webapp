<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" scope="page" ><fmt:message key = "register_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>		
			<%-- CONTENT --%>
			<div id = "wrap">
			<c:out value="${message}"/>
			
			<form id="addUser" action="controller" method = "post" class="form-signin">
				
				<legend><fmt:message key = "register_jsp.form.title" /></legend>
				<input type="hidden" name="command" value="addUser"/>
				<label><fmt:message key = "register_jsp.form.login" />:</label><input type="text" name="login" />
				<label><fmt:message key = "register_jsp.form.password" />:</label><input type="password" name="password" />
				<label><fmt:message key = "register_jsp.form.fname" />:</label><input type="text" name="fullName" />
				<label><fmt:message key = "register_jsp.form.email" />:</label><input type="text" name = "email"/>
				<input type="submit" value = "Sumbit"/>
				
			</form>
			
			<%-- CONTENT --%>
		</div>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		

