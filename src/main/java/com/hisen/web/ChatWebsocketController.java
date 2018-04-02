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
    public String loginverify(String userid,String userpassword,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//System.out.println(userid+"--userid"+userpassword+"--userpassword");
    	System.out.println(request.getParameter("userid")+"--userid"+request.getParameter("userpassword")+"--userpassword");
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("userid", userid);
    	
    	WebSocketTest.setHttpSession(session);
    	//request.getRequestDispatcher("/socketChat.jsp").forward(request, response);
    		
    	return "friendslist";
    	
//        HttpSession session=request.getSession();  
//        session.setAttribute("username", username);  
//        WebSocketTest.setHttpSession(session);  
        //request.getRequestDispatcher("/friendslist.jsp").forward(request, response);  
    }  
    @RequestMapping("loginOut")  
    public String loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        HttpSession session=request.getSession();  
        session.removeAttribute("userid");  
        //request.getRequestDispatcher("/socketChat.jsp").forward(request, response);  
        
        return "login";
    }  
} 