
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

//获取当前登陆用户userid
//var userid = $(session.userid)
console.log(userid,"当前登陆userid为")

//获取好友列表
$.get("/BookSystem_V0/showfriend/friendslist",function(data,status){
	
	let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
	for(let i=0;i<data.length;i++){
		fid =data[i].friendId
		fname = data[i].friendName
		html += '<li><a href=\"#\" onclick=\"chatWithxx('+ fid+',\''+fname +'\')\">'+data[i].friendName+'</a></li>'
	}
	$("#friendslist").html(html)
	console.log(data)
	console.log("")
	console.log("require friendslist:"+status)
	
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
//        debugger  
//        var messageJson=eval("("+event.data+")");  
//        if(messageJson.messageType=="message"){  
//            setMessageInnerHTML(messageJson.data);  
//        }  
//        if(messageJson.messageType=="onlineCount"){  
//            document.getElementById('onlineCount').innerHTML=messageJson.data;  
//        }  
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
	$("#chatwindowtitle").html("与"+va2+"聊天");
	$("#chatwindowcontent").html("</br></br></br></br>");
}
function sendmessage(){
	console.log("sending message:"+$("#chatwindowmessage").html())
	let message = $("#chatwindowmessage").val()
	websocket.send(message)
	contenthtml = $("#chatwindowcontent").html()
	contenthtml += message
	$("#chatwindowcontent").html(contenthtml+"</br>")
	console.log("message send to server done")
}

