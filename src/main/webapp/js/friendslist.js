
console.log("loading friendlist.js")
var websocket = null;  
let html = null;
//用于拼接聊天内容。在函数sendmessage,websocket.onmessage处调用
let contenthtml  

//获取当前登陆用户userid
//var userid = $(session.userid)
console.log("当前登陆userid为",userid)

//存储当前选择的聊天好友
let friendid
let friendname

//用来存储当前登陆用户的所有好友
let friendAll = new Array();

//获得window.localStorage
let storage = window.localStorage;

//font awesome 图标html
//let fontawesomeHtml = '<span class=\"fa-stack fa-lg\" style=\"font-size:14px;\"><i class=\"fa fa-circle-thin fa-stack-2x\" ></i><i class=\"fa fa-twitter fa-stack-1x\"></i></span>'
//获取好友列表
console.log("正在向服务器请求好友列表");
$.post("/BookSystem_V0/showfriend/friendslist/"+userid,function(data,status){
	console.log("data",data);
	friendAll = data;
	let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
	for(let i=0;i<data.length;i++){
		fid =data[i].userid
		fname = data[i].usernickname
		html += '<li id=\"friendlistid'+ fid +'\"> <a href=\"#\" onclick=\"chatWithxx('+ fid+',\''+fname +'\')\">'+data[i].usernickname+'</a></li>'
	}
	$("#friendslist").html(html)
	console.log("请求好友列表:"+status)
	
})
//装载聊天窗口
html = $("#chatwindow").load("../chatwindow.jsp",function(){
	console.log("load chatwindow successfully")
})
//初始化websocket连接
//判断当前浏览器是否支持WebSocket  
if ('WebSocket' in window) {  
    websocket = new WebSocket("ws://localhost:8080/BookSystem_V0/websocketTest");  
    console.log("attempt to connect the server by using websocket")
    
    window.setInterval(function(){ //每隔50秒发送一次心跳，避免websocket连接因超时而自动断开
    	websocket.send("ping@"+" ");
    	console.log("send ping test");
    	},50000);
} else {  
    alert('当前浏览器 Not support websocket')  
}  
//连接发生错误的回调方法  
websocket.onerror = function() {  
    console.log("WebSocket连接发生错误");  
};  
//连接成功建立的回调方法  
websocket.onopen = function() {  
    console.log("WebSocket连接成功");  
    
}
//接收到消息的回调方法  
websocket.onmessage = function(event) {  
    
    var messageJson=eval("("+event.data+")");  
    var mJData = new Array();
   	mJData = messageJson.data.split(":");
   	console.log("mJData",mJData);
   	//当前打开的聊天窗口不是发送来的消息好友id
   	
	//拼接样式 模板
	let contenthtmlStylePre = '<div class="messageStyle" style="height:35px;background-color:rgb(66, 139, 202);float:left;line-height:20px;padding:10px;border-radius:10px;">'
	let contenthtmlStyleSuff = '</div></br>'
//	let messageModel = '<div style="margin:30px;">'+'<div class="messageStyle" style="height:20px;float:left;line-height:20px;padding:10px">' + "我说：" + '</div>' + contenthtmlStylePre +message + contenthtmlStyleSuff+'</div>';

   	
   	if(friendid!=mJData[0]){
   		//定制新消息发来的html格式
   		let newMessageHtml;
   		//把新消息的HTML格式设置成 朋友nickname说：新消息
//   		newMessageHtml = findUsernameByUserid(mJData[0])+"说："+mJData[1];
   		let messageModel = '<div style="margin:30px;">'+'<div class="messageStyle" style="height:20px;float:left;line-height:20px;padding:10px">' + findUsernameByUserid(mJData[0]) +'说：' + '</div>' + contenthtmlStylePre + mJData[1] + contenthtmlStyleSuff+'</div>';

   		//拼接老消息和新消息重新放到localstorage中，
//   		newMessageHtml = storage.getItem("contentHtmlfriendid"+mJData[0])+newMessageHtml+"</br>";
   		newMessageHtml = storage.getItem("contentHtmlfriendid"+mJData[0])+messageModel+"</br>";
   		
   		storage.setItem("contentHtmlfriendid"+mJData[0],newMessageHtml);
   		
   		$('#friendlistid'+mJData[0]).addClass('newMessage'); 
   	}
   	
    if(messageJson.messageType=="message"&&mJData[0]==friendid){  
        contenthtml = $("#chatwindowcontent").html();
   		let messageModel2 = '<div style="margin:30px;">'+'<div class="messageStyle" style="height:20px;float:left;line-height:20px;padding:10px;border-radius:10px;">' + friendname +'说：' + '</div>' + contenthtmlStylePre + mJData[1] + contenthtmlStyleSuff+'</div>';
   		contenthtml += messageModel2;
//        contenthtml = contenthtml + friendname + "说：";
//    	contenthtml += mJData[1];
        $("#chatwindowcontent").html(contenthtml);
    }  
    if(messageJson.messageType=="onlineCount"){  
        console.log("messageJson.data"+messageJson.data);  
    }
    
    //滚动页面到底部
    var h = $(document).height()-$(window).height();
    $(document).scrollTop(h); 
    
    
    console.log(event.data) 
    console.log("onmessage 接收到消息")
}  
//连接关闭的回调方法  
websocket.onclose = function() {  
    console.log("WebSocket连接关闭");  
}  
//    监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。  
window.onbeforeunload = function() {  
    closeWebSocket();
    storage.clear();
    console.log("窗口即将关闭，执行后续函数。。。")
}
//关闭WebSocket连接  
function closeWebSocket() {  
    websocket.close();  
}  
function chatWithxx(va1,va2){
//	console.log("friendAll",friendAll);
	//保存当前的聊天内容;
	if(friendid!=undefined){
		storage.setItem("contentHtmlfriendid"+friendid,$("#chatwindowcontent").html());
	}

	
	//读取之前的聊天内容;
	if(storage.getItem("contentHtmlfriendid"+va1)==null){
		//如果是第一次载入，则在聊天窗内换行四次，作为初始化聊天窗。
		$("#chatwindowcontent").html("</br>");
	}else{
		//如果之前已经聊过天了，则应该存在键值，读取键值中value;
		$("#chatwindowcontent").html(storage.getItem("contentHtmlfriendid"+va1));
	}
	
	//移除新消息提示样式
	$('#friendlistid'+va1).removeClass('newMessage');
	console.log("now chatting with friendId:"+va1);
	
	//重新设置当前聊天对象
	friendid = va1;
	friendname = va2;
	
	//更改聊天窗口标题
	$("#chatwindowtitle").html("与"+va2+"聊天");
	
}
function sendmessage(){
	console.log("sending message:"+$("#chatwindowmessage").val());
	//取输入框中的值
	let message = $("#chatwindowmessage").val();
	//发送消息到服务器
	websocket.send(friendid+"@"+message);
	
	//拼接样式 模板
	let contenthtmlStylePre = '<div class="messageStyle" style="height:35px;background-color:rgb(92, 184, 92);float:left;line-height:20px;padding:10px;border-radius:10px;">'
	let contenthtmlStyleSuff = '</div></br>'
	let messageModel = '<div style="margin:30px;">'+'<div class="messageStyle" style="height:20px;float:left;line-height:20px;padding:10px;">' + "我说：" + '</div>' + contenthtmlStylePre +message + contenthtmlStyleSuff+'</div>';
	//将消息显示在聊天窗口上
	contenthtml = $("#chatwindowcontent").html();
//	contenthtml = contenthtml + "我说:";
	contenthtml += messageModel;

	console.log("contenthtml",contenthtml);
	$("#chatwindowcontent").html(contenthtml);
	
	console.log("message send to server done");
	
	//发送完消息后，清除输入框的内容
	$('#chatwindowmessage').val('');
	$('#chatwindowmessage').focus();
	//滚动页面到底部
    var h = $(document).height()-$(window).height();
    $(document).scrollTop(h); 
}

function findUsernameByUserid(id){
	for(let i=0;i<friendAll.length;i++){
		if(friendAll[i].userid==id){
			return friendAll[i].usernickname
		}
	}
	console.log("func findUsernameByUserid return statement:didnt find usernickname by userid:"+id);
}

