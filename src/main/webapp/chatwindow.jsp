<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1 id="chatwindowtitle" class="page-header">XXXXX的聊天窗口</h1>

<div class="row placeholders">

	<div class="col-xs-12 col-sm-12 placeholder"
		style="word-wrap: break-word; text-align: left">
		<div id="chatwindowcontent" class="row">
			选择好友开始聊天 </br> </br> </br> </br>
		</div>
	</div>

	<div
		class="navbar-fixed-bottom col-sm-8 col-sm-offset-3 col-md-8 col-md-offset-2">
		<textarea id="chatwindowmessage" class="form-control" rows="4" style="resize: none"></textarea>
	</div>
	<div class="navbar-fixed-bottom col-sm-2 col-sm-offset-10 col-md-2 col-md-offset-10">
		<!-- Indicates a successful or positive action -->
		<button type="button" class="btn btn-primary" style="width: 300px;">（首选项）Primary</button>
		<button type="button" class="btn btn-success" style="width: 300px;"  onclick="sendmessage()">（成功）Success</button>
		<button id="sendMessage" onclick="sendmessage()" type="button" class="btn btn-primary "
			style="width: 300px;">发送</button>
	</div>

</div>