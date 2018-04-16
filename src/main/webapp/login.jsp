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
<meta name="author" content="Chenyongming">
	
<!-- Bootstrap CSS -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="./css/signin.css" rel="stylesheet">
<style>

</style>
</head>  
  
<body>
<!-- 	背景视频 -->
	<div >
		<video  style="position:fixed;right: 0; bottom: 0;min-width: 100%; min-height: 100%;width: auto; height: auto; z-index: -100;"
				
				loop="loop" 
				autoplay="autoplay" 
				src="./video/bgVideo.mp4" 
				class="video-tvc" 
				id="video-tvc" 
				poster="//s3a.bytecdn.cn/aweme/resource/web/static/image/index/poster_161268d.png">
				抱歉，您的浏览器不支持内嵌视频
		</video>
	</div>
	<div class="container">
		<form class="form-signin" action="login/loginverify" method="post">
	        <h2 class="form-signin-heading" style="color:white">请登录</h2>
	        <label for="userid" class="sr-only">User Id</label>
	        <input type="text" id="userid" name="userid" class="form-control" placeholder="USER ID" required autofocus>
	        <label for="userpassword" class="sr-only">Password</label>
	        <input type="password" id="userpassword" name="userpassword" class="form-control" placeholder="PASSWORD" required>
	        <div class="checkbox">
	          <label >
	            <input type="checkbox" value="remember-me" ><span style="color:white">Remember me</span>
	          </label>
	        </div>
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	        <button class="btn btn-lg btn-primary btn-block"  data-toggle="modal" data-target="#myModal">Sign up</button>
<!-- 	        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button> -->
<!-- 			<button class="btn btn-lg btn-primary btn-block" data-toggle="modal" data-target="#myModal">开始演示模态框</button> -->
      </form>
	</div> 
	

	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						注册
					</h4>
				</div>
				<div class="modal-body">
					<form class="form-signin" action="login/signup" method="post" id="signupForm">
				        
				        <label for="useridsignup" class="sr-only">User Id</label>
				        <input type="text" id="useridsignup" name="useridsignup" class="form-control" placeholder="USER ID" required autofocus>
				        
				        <label for="userpassword" class="sr-only">Password</label>
				        <input type="password" id="userpasswordsignup" name="userpasswordsignup" class="form-control" placeholder="PASSWORD" required>
				        
				        <label for="userpassword2" class="sr-only">Check Password Again</label>
				        <input type="password" id="userpassword2signup" name="userpassword2signup" class="form-control" placeholder="PASSWORD AGAIN" required>
				        
				        <label for="useremailsignup" class="sr-only">Email</label>
				        <input type="text" id="useremailsignup" name="useremailsignup" class="form-control" placeholder="Email" required>
				        
				        <div class="checkbox">
				          <label>
				            <input type="checkbox" value="remember-me" ><span style="color:black">同意用户协议</span>
				          </label>
				        </div>
				      </form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">返回
					</button>
					<button type="button" class="btn btn-primary" onClick="submitSignup()">
						提交注册
					</button>
				</div>
			</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
	 
<!-- the origial version -->
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
<!-- 	<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="./js/login.js" charset="utf-8"></script>
</body>  
</html> 