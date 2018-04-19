<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false"%>
<% String appPath = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="ChenYongming">
<link rel="icon" href="../../favicon.ico">

<title>Friends List</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap core JavaScript================================================== -->
<!-- <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script> -->
<!-- <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- Custom styles for this template -->
<link href="../css/dashboard.css" rel="stylesheet">
<link href="../css/friendlist.css" rel="stylesheet">
<!-- css font awesome -->
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./friendslist.jsp">Welcome to bysj chatting room</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					
					<li><a data-toggle="modal" data-target="#profileModal" onclick="getUserinfo()">个人资料设置</a></li>
					<li><a data-toggle="modal" data-target="#addFriendModal">添加好友</a></li>
					
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar" id="friendslist">
					<li class="active"><a href="#">Overview <span
							class="sr-only">(current)</span></a></li>
					<!-- 					<li><a href="#">好友名字xxx</a></li> -->
					<!-- 好友列表显示位 -->
				</ul>
			</div>
			<div id="chatwindow" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<!--容器 -->
				<!--  <input type="button" value="button" onclick="send()"></input> -->
			</div>
		</div>
	</div>
	
	<!-- Button trigger modal -->
<!-- 	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"> -->
<!-- 	  Launch demo modal -->
<!-- 	</button> -->
	<!-- profileModal -->
	<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">个人资料编辑</h4>
	      </div>
	      <div class="modal-body">
	        <form class="form-horizontal" action="<%=appPath%>/userinfo/updateuserinfo" method="post" id="updateUserinfoForm">
				<div class="form-group">        
			        <label for="useridprofile" class="col-md-3 control-label">User Id</label>
			        <div class="col-md-6">
			        	<input type="text" id="useridprofile" name="useridprofile" class="form-control" placeholder="USER ID" required autofocus>
			        </div>
		        </div>
		        
		        <div class="form-group">        
			        <label for="usernicknameprofile" class="col-md-3 control-label">Nickname</label>
			        <div class="col-md-6">
			        	<input type="text" id="usernicknameprofile" name="usernicknameprofile" class="form-control" placeholder="Nickname" required>
			        </div>
		        </div>
		        <div class="form-group">        
			        <label for="useremailprofile" class="col-md-3 control-label">Email</label>
			        <div class="col-md-6">
			        	<input type="text" id="useremailprofile" name="useremailprofile" class="form-control" placeholder="Email" required>
			        </div>
		        </div>
		        <div class="form-group">        
			        <label for="usersignatureprofile" class="col-md-3 control-label">Signature</label>
			        <div class="col-md-6">
			        	<input type="text" id="usersignatureprofile" name="usersignatureprofile" class="form-control" placeholder="Signature" required>
			        </div>
		        </div>
		        
		      </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary" onclick="updateUserinfo()">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>



	<!-- addFriendModal模态框（Modal） -->
<div class="modal fade" id="addFriendModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="addFriendModalLabel">
					添加好友
				</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" action="<%=appPath%>/showfriend/addfriend" method="post" id="updateUserinfoForm">
					<div class="form-group">        
				        <label for="useridaddFriend" class="col-md-3 control-label">User Id</label>
				        <div class="col-md-6">
				        	<input type="text" id="useridaddFriend" name="useridaddFriend" class="form-control" placeholder="USER ID" required autofocus>
				        </div>
			        </div>
			     </form>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-9 col-md-offset-2" style="word-break:break-all" id="findFriendResult">
						
						
					</div>
				
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="findFriend()">
					查找
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- addFriendConfirmModal模态框（Modal） -->
<div class="modal fade" id="addFriendConfirmModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="addFriendConfirmModalLabel">
					添加好友
				</h4>
			</div>
			<div class="modal-body" id="addFriendConfirmBody">
				......
				<input type="hidden" id="bus">
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-9 col-md-offset-2" style="word-break:break-all" id="findFriendResult">
<!-- 						添加好友--确认用户存在--确认是否添加--确认--传递要添加的用户 和 当前登陆的用户--获取要添加用户的所有信息封装--添加到当前登陆用户的好友表里 -->
<!-- 						√           √            √          √      √                  ×               √                      × -->
<!-- 																				  前端传回当前登陆的用户						↑ -->
<!-- 																				  或者后端直接获取session----------------------- -->
					</div>
				
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" onclick="confirmadd()">
					确认
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!-- 成功失败状态模态框（Modal） -->
<div class="modal fade" id="statusModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="statusModalLabel">
					添加好友状态
				</h4>
			</div>
			<div class="modal-body" id="statusModalBody">
				......
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
<!-- 	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script> -->
<!-- 	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>


	<!-- Custom script for this template -->
	
	<script  type="text/javascript">
	//获取session域中的值	
	var userid = '<%=session.getAttribute("userid")%>';
	var appPath = '<%=appPath%>';
		
	</script>
	
	
	<script src="../js/friendslist.js" charset="utf-8"></script>
	<script src="../js/navbar.js" charset="utf-8"></script>
	<!-- 	<script src="./js/websocket.js" charset="utf-8"></script> -->



</body>
</html>
