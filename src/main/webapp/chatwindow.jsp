<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="row placeholders">
	<h1 id="chatwindowtitle" class="page-header">XXXXX的聊天窗口</h1>

</div>
<div class="row placeholders">
	<div class="col-xs-12 col-sm-12 placeholder" style="word-wrap: break-word; text-align: left">
		<div id="chatwindowcontent" class="row">
			选择好友开始聊天 </br> </br> </br> </br>
		</div>
	</div>
</div>
<div class="row placeholders">
	<div class="navbar-fixed-bottom col-sm-8 col-sm-offset-3 col-md-8 col-md-offset-2">
		<textarea id="chatwindowmessage" class="form-control" rows="4" style="resize: none"></textarea>
	</div>
	<div class="navbar-fixed-bottom col-sm-2 col-sm-offset-10 col-md-2 col-md-offset-10">
		<!-- Indicates a successful or positive action -->
		<button type="button" class="btn btn-primary" style="width:250px;margin:2px" onclick="">发送图片</button>
		<input type="file" id="exampleInputFile" style="display:none">
		<button type="button" class="btn btn-success" style="width:250px;margin:2px"  onclick="sendmessage()">发送消息</button>
		<button id="sendMessage" onclick="sendmessage()" type="button" class="btn btn-primary" style="width:250px;margin:2px">还不知道要用来干嘛的按钮</button>
	</div>

</div>