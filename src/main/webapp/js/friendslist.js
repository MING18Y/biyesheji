
//$(document).ready(function(){
//	//获取好友列表
//	$.get("/Booksystem_V0/showfriend/friendslist",function(data,status){
//		let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
//		for(let i=0;i<data.length;i++){
//			html += '<li><a href=\"#\" onclick=\"chatWithxx('+ data[i].friendId + ')\">'+data[i].friendName+'</a></li>'
//		}
//		$("#friendslist").html(html)
//		console.log(data)
//		console.log("")
//		console.log("require friendslist:"+status)
//	})
//	
//	
//	//	$("#friendslist").html("<li><a href="#">"+html+"</a></li>")
//})
console.log("friendlist.js")
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

//获取好友列表
console.log("正在向服务器请求好友列表");
$.post("/BookSystem_V0/showfriend/friendslist/"+userid,function(data,status){
	console.log("data",data);
	let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
	for(let i=0;i<data.length;i++){
		fid =data[i].userid
		fname = data[i].usernickname
		html += '<li><a href=\"#\" onclick=\"chatWithxx('+ fid+',\''+fname +'\')\">'+data[i].usernickname+'</a></li>'
	}
	$("#friendslist").html(html)
	console.log(data)
	console.log("")
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
    if(messageJson.messageType=="message"){  
//        setMessageInnerHTML(messageJson.data);
    	
        contenthtml = $("#chatwindowcontent").html();
        console.log("messageJson:",messageJson)
    	contenthtml += messageJson.data;
        $("#chatwindowcontent").html(contenthtml+"</br>");
    }  
    if(messageJson.messageType=="onlineCount"){  
        console.log("messageJson.data"+messageJson.data);  
    }  
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
    console.log("窗口即将关闭，执行后续函数。。。")
}
//关闭WebSocket连接  
function closeWebSocket() {  
    websocket.close();  
}  
function chatWithxx(va1,va2){
	console.log("now chatting with friendId:"+va1);
	friendid = va1;
	friendname = va2;
	$("#chatwindowtitle").html("与"+va2+"聊天");
	$("#chatwindowcontent").html("</br></br></br></br>");
}
function sendmessage(){
	console.log("sending message:"+$("#chatwindowmessage").val());
	
	let message = $("#chatwindowmessage").val();
	websocket.send(friendid+"@"+message);
	contenthtml = $("#chatwindowcontent").html();
	contenthtml += message;
	$("#chatwindowcontent").html(contenthtml+"</br>");
	
	console.log("message send to server done");
}

