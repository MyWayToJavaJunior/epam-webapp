<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Routes" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<table id="main-container">
			<td class="content">			
			<%-- CONTENT --%>
			
			<c:out value="${message}"/>
			
			<form id="addUser action="controller" method = "post">
			
				<input type="hidden" name="command" value="addUser"/>
				<input type="text" name="login" />
				<input type="password" name="password" />
				<input type="text" name="fullName" />
				<input type="text" name = "email"/>
				<input type="submit" value = "Sumbit"/>
				
			</form>
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
