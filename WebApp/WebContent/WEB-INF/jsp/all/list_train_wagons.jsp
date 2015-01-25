<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Routes" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<table id="main-container">
			
		
			
		<tr>
		<td>
<!-- 			<form id="listTrains" action="controller"> -->
<!-- 				<input type="hidden" name="command" value="listTrains"/> -->
<!-- 				<input type="date" name="startDate" /> -->
<!-- 				<input type="date" name = "endDate" /> -->
<!-- 				<input type="submit" value = "Show"/> -->
<!-- 			</form> -->
			
		</td>
			<td class="content">			
			<%-- CONTENT --%>
			<form action="controller" method = "post"> 
			<input type = "hidden" name="command" value = "buyTicket" />
			<input type = "text" name="fullName" />
			<c:forEach var="bean" items="${wagons}">
					<tr>
						<td>№${bean.number}</td>
						<td>${bean.type.typeName}</td>
						<td>${bean.seats}</td>
						<td><input type = "radio" name = "wagonId" value = "${bean.id}"/></td>
					</tr>
				</c:forEach>	
			<tr><input type = "submit" value = "Buy" align = "ABSBOTTOM"/></tr>
			</form>
<%-- 			<c:forEach var="bean" items="${wagons}"> --%>
<!-- 					<tr> -->
<%-- 						<td>${bean.type.typeName} </td> --%>
<%-- 						<td>${bean.seats}</td> --%>
<%-- 						<td><a href="controller?command=buyTicket&wagonId=${bean.id}">Buy ticket</a></td> --%>
<!-- 					</tr> -->

<%-- 				</c:forEach>			 --%>
			
			
			
			
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
