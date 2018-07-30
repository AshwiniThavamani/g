function showYearDiv(){
	if(document.getElementById('rd').checked ||
			document.getElementById('fd').checked)
		document.getElementById('yearsDiv').style.display='block';
	else
		document.getElementById('yearsDiv').style.display='none';
}
/*function showWithdraw(){
	if(document.getElementById('debit').checked)
		document.getElementById('Withdraw').style.display='block';
	else
		document.getElementById('Withdraw').style.display='none';
}*/
function showButton(){
	if(document.getElementById('credit').checked){
		document.getElementById('btnType').value="Deposit";
	}else{
		document.getElementById('btnType').value="Withdraw";
	}
}

/*function showButton(){
	if(document.getElementById('credit').checked)
		document.getElementById('Deposit').style.display='block';
	else
		document.getElementById('Withdraw').style.display='block';
}*/
/*function showWithdraw() {
    var x = document.getElementById("Withdraw");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function showDeposit() {
    var x = document.getElementById("Deposit");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}*/



window.onload= function(){
	document.getElementById('yearsDiv').style.display='none';
}

/*window.onload= function(){
	document.getElementById('Deposit').style.display='none';
}
window.onload= function(){
	document.getElementById('Withdraw').style.display='none';
}*/


function validateForm(){
	var uname=myform.userName.value;
	var upwd=myform.userPwd.value;
	
	var flag=false;
	if(uname==""||uname==null){
		document.getElementById('userErrMsg').innerHTML=" * Please enter userName.";
		
	}
	else if(upwd=="" || upwd==null)
		{
		flag=false;
		document.getElementById('userErrMsg').innerHTML="";
		document.getElementById('pwdErrMsg').innerHTML=" * Please enter password.";
		}
	else{
		flag=true;
		document.getElementById('userErrMsg').innerHTML="";
		document.getElementById('pwdErrMsg').innerHTML="";
	}
	
	return flag;
}