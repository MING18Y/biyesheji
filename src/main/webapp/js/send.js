var data = {};//新建data对象，并规定属性名与相应的值
            data['fromId'] = sendUid;
            data['fromName'] = sendName;
            data['toId'] = to;
            data['messageText'] = $(".contactDivTrue_right_input").val();
            webSocket.send(JSON.stringify(data));//将对象封装成JSON后发送至服务器