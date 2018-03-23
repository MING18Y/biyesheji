$(document).ready(function(){
	
	console.log("loading login.jsp")
	
	
	
})
function login(){
	var userid = $("#userid").val
	var password = $("#userpassword").val
	
	$.get('/Booksystem_V0/login/loginverify',{userid,password},function(){
		
	
	}); 
}