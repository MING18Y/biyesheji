package com.hisen.web;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.hisen.web.WebSocketTest;  
  
@Controller  
@RequestMapping("login")  
public class ChatWebsocketController {  
    @RequestMapping("loginverify")  
    public void loginverify(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	System.out.println(request);
//        HttpSession session=request.getSession();  
//        session.setAttribute("username", username);  
//        WebSocketTest.setHttpSession(session);  
        request.getRequestDispatcher("/socketChat.jsp").forward(request, response);  
    }  
    @RequestMapping("loginOut")  
    public void loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        HttpSession session=request.getSession();  
        session.removeAttribute("username");  
        request.getRequestDispatcher("/socketChat.jsp").forward(request, response);  
    }  
} 