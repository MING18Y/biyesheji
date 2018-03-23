var webSocket = new WebSocket("ws://localhost:8080/Booksystem_V0");
webSocket.onopen = function(event){
    console.log("连接成功");
    console.log(event);
};
webSocket.onerror = function(event){
    console.log("连接失败");
    console.log(event);
};
webSocket.onclose = function(event){
    console.log("Socket连接断开");
    console.log(event);
};
webSocket.onmessage = function(event){
    //接受来自服务器的消息
    //...
}