<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./resources/css/myStyles.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<form:form action="deposit" method="post"
		modelAttribute="transaction">
<div id="bankCnt">
	<h2>Deposit Page</h2>
	<hr>

	<form>
		<table>
			<tr>
				<td>Choose Account::</td>
				<td><form:select path="accountType">
						<option  value="${transaction.fromAccount.accountNo}-${transaction.fromAccount.accountType}" >Savings</option>
						<option  value="${transaction.fromAccount.accountNo}-${transaction.fromAccount.accountType}">Current</option>
						<option  value="${transaction.fromAccount.accountNo}-${transaction.fromAccount.accountType}">RD</option>
						<option  value="${transaction.fromAccount.accountNo}-${transaction.fromAccount.accountType}">FD</option>
				</form:select></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input type="text" path="description" value="${transaction.description }" size="20"/></td>
			</tr>
			
			<tr>
			<td><form:radiobutton path="transactionType"
							 value="${transaction.transactionType}" />
						Deposit </td>
						<td><form:radiobutton path="transactionType" value="${transaction.transactionType}" />
						Withdraw</td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><form:input type="text" path="amount" value="${transaction.amount }" size="20"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="deposit" value="Deposit"></td>


			</tr>
		</table>
		<hr>
		<table border="1">
		<tr>
		<td>Current balance:</td>
		<td><input type="text" name="currentBalance" size=25></td>
		</tr>
		
		</table>
	</form>
	</div>
	</form:form>
</body>
</html>