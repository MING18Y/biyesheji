console.log("loading login.jsp")

function login(){
	var userid = $("#userid").val;
	var password = $("#userpassword").val;
	
	$.get('/Booksystem_V0/login/loginverify',{userid,password},function(){
		
	
	}); 
}
//打开注册框
function submitSignup(){
	console.log("validting data...");
	console.log('$("#useridsignup").val()',$("#useridsignup").val());
	console.log('$("#userpasswordsignup").val()',$("#userpasswordsignup").val());
	console.log('$("#userpassword2signup").val()',$("#userpassword2signup").val());
	console.log('$("#useremailsignup").val()',$("#useremailsignup").val());
	
	if($("#useridsignup").val()==""){
		alert("please input your id");
		return;
	}
	if($("#userpasswordsignup").val()==""){
		alert("please input your password");
		return;
	}
	if($("#userpassword2signup").val()==""){
		alert("please input password twice");
		return;
	}
	if($("#useremailsignup").val()==""){
		alert("please input email");
		return;
	}
	if($("#userpasswordsignup").val()!=$("#userpassword2signup").val()){
		alert("different password detected");
		return;
	}
	
	console.log("Submitting user signup info");
	$("#signupForm").submit();
}