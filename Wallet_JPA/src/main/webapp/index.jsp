<html>
<head>

<link href="./resources/css/myStyles.css" rel="stylesheet"
	type="text/css">

<script type="text/javascript" src="./resources/script/myScript.js"></script>

</head>
<body>
	<div id="bankCnt">
		<h2 align="center">CapG Banking Application</h2>
		
		<hr>
		<fieldset style="width: 500px; margin-left: 200px;">
			<legend>Login form</legend>
			<form name="myform" method="post"  onsubmit="return validateForm()" action="validateLogin" >
<table>
					<div id="imgcnt1">
						<img alt="bank" src="./resources/images/bank1.png" width="400"
							height="100" align="middle">
					</div>
					<br><br>
		<tr>
			<th colspan="3">Login Form </th>
		</tr>
		<tr>
			<td>Customer Id:</td>
			<td>
				<input type="text" name="customerId" size="20">
			</td>
			<td>
				<div id="userErrMsg" class="errMessage"></div>
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
				<input type="password" name="customerPwd" size="20">
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

		<hr>

		<div id="footer">
			<div style="float: left;">Capgemini Flp 2018</div>
			<div style="margin-left: 700px;">Java FLp</div>
		</div>

	</div>
	<hr>
</body>
</html>
