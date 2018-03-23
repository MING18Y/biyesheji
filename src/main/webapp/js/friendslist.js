//$(document).ready(function(){
//
//	
//	$.get("/Booksystem_V0/showfriend/friendslist",function(data,status){
//		let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
//		for(let i=0;i<data.length;i++){
//			html += '<li><a href=\"#\" onclick=\"chatWithxx('+ data[i].friendId + ')\">'+data[i].friendName+'</a></li>'
//		}
//		$("#friendslist").html(html)
//		console.log(data)
//		console.log("")
//		console.log("require friendslist:"+status)
//		
//	})
//	
//	console.log("friendlist.js")
//	//	$("#friendslist").html("<li><a href="#">"+html+"</a></li>")
//})
console.log("friendlist.js")
var websocket = null;  

$.get("/Booksystem_V0/showfriend/friendslist",function(data,status){
	let html ="<li class=\"active\"><a href=\"#\">好友列表<span class=\"sr-only\">(current)</span></a></li>"
	for(let i=0;i<data.length;i++){
		html += '<li><a href=\"#\" onclick=\"chatWithxx('+ data[i].friendId + ')\">'+data[i].friendName+'</a></li>'
	}
	$("#friendslist").html(html)
	console.log(data)
	console.log("")
	console.log("require friendslist:"+status)
	
})

function chatWithxx(friendId){
	console.log("friendId = "+friendId)
    
    
    //判断当前浏览器是否支持WebSocket  
    if ('WebSocket' in window) {  
        websocket = new WebSocket("ws://localhost:8080/Booksystem_V0/websocketTest");  
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
//    websocket.onclose = function() {  
//        console.log("WebSocket连接关闭");  
//    }  
//    监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。  
    window.onbeforeunload = function() {  
        closeWebSocket();
        console.log("窗口即将关闭，执行后续函数。。。")
    }
    
   
//    websocket.send("message from websocket.send()")
	
    
}
function send(){
	console.log(websocket)
	websocket.send("message:llalalalalala")
}
//
//function setMessageInnerHTML(innerHTML) {  
//    document.getElementById('message').innerHTML += innerHTML + '<br/>';  
//}  
//
//关闭WebSocket连接  
function closeWebSocket() {  
    websocket.close();  
}  
//
//发送消息  
//function send(websocket) {  
//    var message = document.getElementById('text').value;  
//    var username = document.getElementById('username').value;  
//    websocket.send(username+"@"+message);  
//	websocket.send("message from function send()")
//	console.log("send message success")
//    document.getElementById('message').innerHTML += message + '<br/>';  
//}  

//var websocket = null;
//    //判断当前浏览器是否支持WebSocket
//    if ('WebSocket' in window) {
//        websocket = new WebSocket("ws://localhost:8080/Booksystem_V0/websocketTest");
//    }
//    else {
//        console.log('当前浏览器 Not support websocket')
//    }
//
//    //连接发生错误的回调方法
//    websocket.onerror = function () {
//        console.log("WebSocket连接发生错误");
//    };
//
//    //连接成功建立的回调方法
//    websocket.onopen = function () {
//        console.log("WebSocket连接成功");
//    }
//
//    //接收到消息的回调方法
//    websocket.onmessage = function (event) {
//        console.log(event.data);
//    }
//
//    //连接关闭的回调方法
//    websocket.onclose = function () {
//        console.log("WebSocket连接关闭");
//    }
//
//    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
//    window.onbeforeunload = function () {
//        closeWebSocket();
//    }
//
//    //将消息显示在网页上
//    function setMessageInnerHTML(innerHTML) {
//        document.getElementById('message').innerHTML += innerHTML + '<br/>';
//    }
//
//    //关闭WebSocket连接
//    function closeWebSocket() {
//        websocket.close();
//        console.log("closed websocket")
//    }
//
//    //发送消息
//    function send() {
//        var message = document.getElementById('text').value;
//        websocket.send(message);
//        console.log("send() message ")
//    }
//
//
//
