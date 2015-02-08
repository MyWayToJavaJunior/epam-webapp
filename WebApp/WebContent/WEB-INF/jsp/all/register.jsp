<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Registration" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>		
			<%-- CONTENT --%>
			<div id = "wrap">
			<c:out value="${message}"/>
			
			<form id="addUser" action="controller" method = "post" class="form-signin">
				
				<legend>Type registration data</legend>
				<input type="hidden" name="command" value="addUser"/>
				<label>Login:</label><input type="text" name="login" />
				<label>Password:</label><input type="password" name="password" />
				<label>Full name</label><input type="text" name="fullName" />
				<label>Email:</label><input type="text" name = "email"/>
				<input type="submit" value = "Sumbit"/>
				
			</form>
			
			<%-- CONTENT --%>
		</div>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		

