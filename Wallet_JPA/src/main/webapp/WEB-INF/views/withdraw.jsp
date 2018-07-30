<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./resources/css/myStyles.css" rel="stylesheet"
	type="text/css">
</head>
<body>
<div id="bankCnt">
	<h2>Withdraw Page</h2>
	<hr>

	<form>
		<table>
			<tr>
				<td>Choose A/c:</td>
				<td><select>
						<option value="savings">Savings</option>
						<option value="current">Current</option>
						<option value="RD">RD</option>
						<option value="FD">FD</option>
				</select></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input type="text" name="amount" size="20"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="withdraw" value="Withdraw"></td>


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
</body>
</html>