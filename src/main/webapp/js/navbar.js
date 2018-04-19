$(function(){
	$('#addFriendModal').on('hide.bs.modal',function(){
		//关闭添加好友模态框时触发
		console.log("触发了关闭模态框事件");
		$("#findFriendResult").html("");
	})
	$('#addFriendConfirmModal').on('hide.bs.modal',function(){
		//关闭添加好友模态框时触发
		console.log("触发了关闭模态框事件2");
		founduserid = null;
	})
	$('#statusModal').on('hide.bs.modal',function(){
		//关闭添加好友模态框时触发
		console.log("触发了关闭模态框事件3");
		$("#statusModalBody").html('');
	})
	
})

function getUserinfo(){
	//获取用户信息
	console.log("正在向服务器请求用户信息");
	$.post("/BookSystem_V0/userinfo/getuserinfo/"+userid,function(data,status){
		console.log("navbarjs data",data);
		
		//给modal里的input框赋值
		$('#useridprofile').val(data.userid);
		$('#usernicknameprofile').val(data.usernickname);
		$('#useremailprofile').val(data.useremail);
		$('#usersignatureprofile').val(data.usersignature);
		
		//禁止修改userid
		$("#useridprofile").attr("readonly","readonly");
		
	})
}

function updateUserinfo(){
	//更新用户信息
	console.log("正在向服务器提交更改");
	
	let userinfo = {
		userid:$('#useridprofile').val(),
		usernickname:$('#usernicknameprofile').val(),
		useremail:$('#useremailprofile').val(),
		usersignature:$('#usersignatureprofile').val(),
	}
	
	$.post("../userinfo/updateuserinfo",userinfo,function(data,status){
		console.log("updateUserinfo status:",status);
	});
	
	$("#profileModal").modal('hide');
//	$("#updateUserinfoForm").submit();

	
}
var founduserid;
function findFriend(){
	console.log("查找好友");
	let useridfindFriend = $("#useridaddFriend").val();
	console.log("navbar:useridfindfriend:",useridfindFriend);
	$.post("../showfriend/findFriend",{useridfindFriend},function(data,status){
		console.log("find friend callback function...");
		console.log("data",data);
		if(data!=null){
//			$("#findFriendResult").html("找到friendid为："+data.userid+",friend昵称："+data.usernickname+"的用户");
			$("#addFriendModal").modal("hide");
			$("#addFriendConfirmModal").modal("show");
			$("#addFriendConfirmBody").html("是否添加id为:"+data.userid+"的用户为好友");
			founduserid = data.userid;
		}
	},"json")
	
	
}
function confirmadd(){
	$.post("../showfriend/addFriend",{founduserid,userid},function(data,status){
		console.log("add friend callback function...");
		console.log("data",data);
		if(data==="success"){
			console.log("添加好友成功");
			//隐藏确认添加好友modal;显示添加状态信息
			$("#addFriendConfirmModal").modal("hide");
			$("#statusModal").modal('show');
			//给状态信息框的html文本赋值;
			$("#statusModalBody").html('添加好友成功');	
		}
		if(data==="alreadyExists"){
			console.log("该用户已经在好友列表中了");
			
			//隐藏确认添加好友modal;显示添加状态信息
			$("#addFriendConfirmModal").modal("hide");
			$("#statusModal").modal('show');
			//给状态信息框的html文本赋值;
			$("#statusModalBody").html('该用户已经在好友列表中了');
		}
		if(data==="failed"){
			console.log("an error occured,please contact the server administrator,chenyongming~");
		}
		
	})
}








