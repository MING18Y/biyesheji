<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://"  
            + request.getServerName() + ":" + request.getServerPort()  
            + path + "/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>  
<base href="<%=basePath%>">
<title>登陆</title>  
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
<!-- Bootstrap CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/signin.css" rel="stylesheet">
<style>

</style>
</head>  
  
<body>
	<div class="container">
		<form class="form-signin" action="login/loginverify" method="post">
	        <h2 class="form-signin-heading">请登录</h2>
	        <label for="userid" class="sr-only">User Id</label>
	        <input type="text" id="userid" name="userid" class="form-control" placeholder="USER ID" required autofocus>
	        <label for="userpassword" class="sr-only">Password</label>
	        <input type="password" id="userpassword" name="userpassword" class="form-control" placeholder="PASSWORD" required>
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> Remember me
	          </label>
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
	</div>  
  
<!--     <form action="chatWebsocket/login" method="post">   -->
<!--         <table>   -->
<!--             <tr>   -->
<!--                 <td>username:</td><td><input type="text" id="username1" name="username"/></td>   -->
<!--             </tr>   -->
<!--             <tr>   -->
<!--                 <td colspan="2"> <input type="submit" value="登录"/></td>   -->
<!--             </tr>   -->
<!--         </table>   -->
<!--     </form>   -->
    
    
  	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script src="./js/login.js" charset="utf-8"></script>
</body>  
</html> 