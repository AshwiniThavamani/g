<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>print transaction</h4>

<table>
<tr>
	<td>From Date:</td>
	<td>
	<div>
		<form:select path="transactionDate">
			
			</form:select>
	</div>

</td>
</tr>
<tr>
	<td>To Date:</td>
	<td>
	<div class="accRow">
		<form:select path="transactionDate">
			
			</form:select>
	</div>
</td>
</tr>
</tr>
<tr><td></td><td><input type="submit" class="btn" value="Print Transaction"/></td></tr>
</table>

<table border=1>
<th>Transaction Date</th>
<th>Description</th>
<th>Debit</th>
<th>Credit</th>

</table>

</body>
</html>