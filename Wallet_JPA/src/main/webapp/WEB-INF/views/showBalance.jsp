<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Balance Page</title>
<link href="./resources/css/myStyles.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="bankCnt">
<h2>Account Summary</h2>
<hr>
<div id="menuCnt">
<table cellpadding="5">
				<tr>
					<th>AccountNumber</th>
					<th>Account Type</th>
					<th>Balance</th>
					<th>Status</th>

				</tr>

				<c:if test="${!empty accounts }">
					<c:forEach items="${accounts}" var="account">
						<tr>
							<td>${account.accountNo}</td>
							<td>${account.accountType}</td>
							<td>${account.updateBalance}</td>
							<td>${account.status}</td>
						</tr>
					</c:forEach>
				</c:if>


			</table>
</div>




</div>
<div id="bankCnt">
<div id="footer">
<div style="float: left;">Capgemini Flp 2018 </div>
	<div style="margin-left: 700px;">Java FLp</div>
</div>
</div>
</body>
</html>