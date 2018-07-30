<html>
<head>

<link href="./resources/css/myStyles.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="./resources/script/myScript.js"></script>

</head>
<body >
<div id="mainCnt">
<h1 align="center"> Capg Banking Application </h1>
<hr>

<div id="imgcnt">
<img alt="bank3" src="./resources/images/bank3.jpg">
</div>
<fieldset style="width: 10px; color:red; margin-top:10px; margin-left: 8px;">
<legend>Login form</legend>
<form name="myform" method="post" action="validateLogin">
	<table>
		<tr>
			<th colspan="3">Login Form </th>
		</tr>
		<tr>
			<td>Customer Id:</td>
			<td>
				<input name="customerId" size="20"/>
			</td>
			<td>
				<div id="userErrMsg" class="errMessage"></div>
			</td>
		</tr>
		<tr>
			<td>Customer Password:</td>
			<td>
				<input type="password" name="customerPwd" size="20"/>
			</td>
			<td>
				<div id="pwdErrMsg" class="errMessage"></div>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="Login">
			</td>
			
		</tr>
		
	</table>


</form>
</fieldset>
</div>
<hr>

<div>
	<div style="float: left;">Capgemini Flp 2018 </div>
	<div style="margin-left: 600px;">Java FLp</div>
</div>
<hr>
</body>
</html>
