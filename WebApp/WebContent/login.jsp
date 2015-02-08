<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<c:set var="title"><fmt:message key="login_jsp.title" /></c:set>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>

<%--=========================================================================== 
Here we use a table layout.
Class page corresponds to the '.page' element in included CSS document.
===========================================================================--%> 
	<table id="main-container">

<%--=========================================================================== 
This is the HEADER, containing a top menu.
header.jspf contains all necessary functionality for it.
Just included it in this JSP document.
===========================================================================--%> 

		<%-- HEADER --%>
		<%@ include file="/WEB-INF/jspf/header.jspf"%>
		<%-- HEADER --%>

<%--=========================================================================== 
This is the CONTENT, containing the main part of the page.
===========================================================================--%> 
		<tr >
			<td class="content center">
			<%-- CONTENT --%>
			
<%--=========================================================================== 
Defines the web form.
===========================================================================--%> 
				<form class="form-signin" id="login_form" action="controller" method="post">
					<input type="hidden" name="command" value="login"/>
					<legend><fmt:message key="login_jsp.form.title" /></legend>
					<fieldset >
						<legend><fmt:message key="login_jsp.form.login" /></legend>
						<input name="login" class="input-block-level"/><br/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key="login_jsp.form.password" /></legend>
						<input type="password" name="password" class="input-block-level"/>
					</fieldset><br/>
					
					<input type="submit" value="Login" class="btn btn-large btn-primary">								
				</form>
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>

</body>
</html>