<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Train info" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>

			
		
			

<!-- 			<form id="listTrains" action="controller"> -->
<!-- 				<input type="hidden" name="command" value="listTrains"/> -->
<!-- 				<input type="date" name="startDate" /> -->
<!-- 				<input type="date" name = "endDate" /> -->
<!-- 				<input type="submit" value = "Show"/> -->
<!-- 			</form> -->
			

			<div id = "wrap">
			<%-- CONTENT --%>
			<form action="controller" method = "post"> 
			<input type = "hidden" name="command" value = "buyTicket" />
			<label>Full name</label><input type = "text" name="fullName" />
			<table class = "table">
			<c:forEach var="bean" items="${train.wagons}">
					<tr>
						<td>№${bean.number}</td>
						<td>${bean.type.typeName}</td>
						<td>${bean.seats}</td>
						<td>${bean.ticketPrice}</td>
						<c:if test="${userRole.name == 'user' }">
						<td><input type = "radio" name = "wagonId" value = "${bean.id}"/></td>
						</c:if>
						<c:if test="${userRole.name == 'admin' }">
						<td><a href="controller?command=deleteWagon&wagonId=${bean.id}&trainId=${train.id}">Delete</a></td>
						</c:if>
					</tr>
				</c:forEach>	
				</table>
			<input type = "submit" value = "Buy"/>
			</form>
			
			<c:if test="${userRole.name == 'admin' }">
			
			<form action="controller" class = "form-signin" method = "post"> 
			<legend>Add wagon</legend>
			<input type = "hidden" name="command" value = "addWagon" />
			<input type = "hidden" name="trainId" value = "${train.id}"/>
			Type: <input type = "text" name="wagonTypeId" class="input-block-level" />
			Number: <input type = "text" name="wagonNumber"  class="input-block-level"/>
			Ticket price: <input type = "text" name="wagonTicketPrice" class="input-block-level" />
			<input type = "submit" value = "Add"/>
			</form>
			
		</c:if>
			
<%-- 			<c:forEach var="bean" items="${wagons}"> --%>
<!-- 					<tr> -->
<%-- 						<td>${bean.type.typeName} </td> --%>
<%-- 						<td>${bean.seats}</td> --%>
<%-- 						<td><a href="controller?command=buyTicket&wagonId=${bean.id}">Buy ticket</a></td> --%>
<!-- 					</tr> -->

<%-- 				</c:forEach>			 --%>
			
			
			
			
			<%-- CONTENT --%>
			</div>

		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
</body>
