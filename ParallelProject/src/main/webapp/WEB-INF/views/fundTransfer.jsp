<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./resources/script/myScript.js"></script>
</head>
<body>
<h1 align="center" >Fund Transfer</h1>

<form:form method="post" action="fundTransaction" modelAttribute="transaction">

<div id="accCnt">
	<div class="accRow">
<table>
<tr>
	<td>Choose From Account:</td>
	<td>
	<div>
		<form:select path="fromAccount.accountNo">
			<c:if test="${!empty accounts}">
				<c:forEach items="${accounts}" var="acc2">
					<form:option value="${acc2.accountNo}">${acc2.accountNo}-${acc2.accountType}</form:option>
				</c:forEach>
			</c:if>
			</form:select>
	</div>
<form:hidden path="fromTransactions.setTransactionType()" value="debit"/>
<form:hidden path="toTransactions.setTransactionType()" value="credit"/>
</td>
</tr>
<tr>
	<td>Choose To Account:</td>
	<td>
	<div class="accRow">
		<form:select path="toAccount.accountNo">
			<c:if test="${!empty accounts}">
				<c:forEach items="${accounts}" var="acc3">
					<form:option value="${acc3.accountNo}">${acc3.accountNo}-${acc3.accountType}</form:option>
				</c:forEach>
			</c:if>
			</form:select>
	</div>
</td>
</tr>

<tr>
<div class="accRow">
	<td>Description:</td>
	<td>

		<form:input type="text" path="description" value=" "/>
	</div>
	</td>
</tr>


<tr>
<div class="accRow">
	<td>Amount:</td>
	<td>


		<form:input type="text" path="amount" value=""/>
	</div>
	</td>
</div>
</tr>
</table>
<div style="margin-left: 230px;">
	<input type="submit" class="btn" value="Transfer">
</div>
	

</div>
</form:form>

</body>
</html>