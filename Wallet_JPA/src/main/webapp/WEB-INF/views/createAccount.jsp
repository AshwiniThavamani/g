<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./resources/script/myScript.js"></script>
</head>
<body>
<form:form modelAttribute="account" method="post" action="saveAccount">
<div id="bankCnt">
<h2>Create Account</h2>
<hr>
<div id="accCnt">
	<div class="accRow">
	<div class="label">Choose Account Type:</div>
	<br>
	<div>
		<form:radiobutton path="accountType" onclick="showYearDiv()" id="savings" value="savings"/>Savings
		<form:radiobutton path="accountType" onclick="showYearDiv()" id="current" value="current"/>Current
		<form:radiobutton path="accountType" onclick="showYearDiv()" id="rd" value="rd"/>Recurring Deposit
		<form:radiobutton path="accountType" onclick="showYearDiv()" id="fd" value="fd"/>Fixed Deposit
		
	</div>
	</div>
	<br>
	<div  class="accRow">
		<div class="label" style="float:left; padding-top: 5px; padding-right:10px; ">Opening Balance:</div>
		<div>
			<form:input path="openingBalance" value=" "/>
		</div>
	</div>
	
	
	<div  class="accRow" id="yearsDiv">
		<div class="label" style="float:left; padding-top: 5px; padding-right:10px; ">Years:</div>
		<div>
			<form:select path="years">
				<c:forEach begin="0" end="15" var="year">
					<form:option value="${year}">${year}</form:option>
				</c:forEach>
			</form:select>
		</div>
	</div>
	
	
	<div style="margin-left: 150px;">
		<input type="submit" class="btn" value="CreateAccount">
	</div>
	
</div>

</div>
<div id="bankCnt">
			<div id="footer">
					<div style="float: left;">Capgemini Flp 2018</div>
					<div style="margin-left: 700px;">Java FLp</div>
				</div>
				</div>
</form:form>
</body>
</html>