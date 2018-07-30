<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Summary</title>
<link href="./resources/css/myStyles.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="bankCnt">
		<h2>Transaction Summary Page</h2>
		<hr>
		
		From Date:
		<input  type="Date" name="FromDate">&nbsp;&nbsp;&nbsp;&nbsp;
		To Date:
		<input  type="Date" name="ToDate"> <br>
		<br>
		<div style="margin-left: 150px;">
		<input type="submit" value="Print Transaction">
		
		</div>
		<table border="1px solid black">
		
		
			<tr>
				<th>Transaction Id</th>

				<th>Transaction Type</th>
				<th>Transaction Description</th>

			</tr>
			<c:if test="${!empty transactions}">
				<c:forEach items="${transactions}" var="transaction">
					<tr>
						<td>${transaction.transactionId}</td>
						<td>${transaction.transactionType}</td>
						<td>${transaction.description}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		
		
	</div>
	<div id="bankCnt">
			<div id="footer">
					<div style="float: left;">Capgemini Flp 2018</div>
					<div style="margin-left: 700px;">Java FLp</div>
				</div>
				</div>
</body>
</html>