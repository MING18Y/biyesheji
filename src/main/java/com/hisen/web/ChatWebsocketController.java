package com.hisen.web;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;

import com.hisen.entity.User;
import com.hisen.service.UserService;
import com.hisen.web.WebSocketTest;  
  
@Controller  
@RequestMapping("login")  
public class ChatWebsocketController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping("loginverify")  
    public String loginverify(String userid,String userpassword,HttpServletRequest request,HttpServletResponse response) throws Exception{
    	//System.out.println(userid+"--userid"+userpassword+"--userpassword");
    	//System.out.println(request.getParameter("userid")+"--userid"+request.getParameter("userpassword")+"--userpassword");
    	//get userid userpassword from jsp form
    	//store the info into variable user
    	User user = new User();
    	user.setUserid(request.getParameter(userid));
    	user.setUserpassword(request.getParameter(userpassword));
    	System.out.println("userinfo acquired:userid:" + userid + ",userpassword" + userpassword );
    	//query userinfo from database if its exists
    	String result = userService.findUserByUseridandUserpassword(userid,userpassword);
    	System.out.println("ChatWebsocketController:line:35:the result of query userid:"+ result);
    	//if user query success set session and return the page friendslist to client
    	if(result == "success") {
    		HttpSession session = request.getSession();
        	session.setAttribute("userid", userid);
        	WebSocketTest.setHttpSession(session);
        	//request.getRequestDispatcher("/socketChat.jsp").forward(request, response);
        	return "friendslist";
    	}else {
    		return "failed";
    	}
// Hisen's original version below    	
//        HttpSession session=request.getSession();  
//        session.setAttribute("username", username);  
//        WebSocketTest.setHttpSession(session);  
        //request.getRequestDispatcher("/friendslist.jsp").forward(request, response);  
    }  
    @RequestMapping("signup")
    public String signup(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	System.out.println("userinfo acquired in signup method:userid:" + request.getParameter("useridsignup")+ ",userpassword:" + request.getParameter("userpasswordsignup")
    			             + ",userpassword2:" + request.getParameter("userpassword2signup") + ",email:" + request.getParameter("useremailsignup"));
    	User user = new User();
    	user.setUserid(request.getParameter("useridsignup"));
    	user.setUserpassword(request.getParameter("userpasswordsignup"));
    	user.setUseremail(request.getParameter("useremailsignup"));
    	
    	//query database if userid is already exists
    	String result = userService.findUserByUserid(user.getUserid());
    	System.out.println("result:"+result);
    	if(result=="continue") {
    		//TODO
    		//用户信息添加
    		userService.addUser(user);
    		//用户信息添加成功后同时为该用户添加好友信息记录表
    		result = userService.createFriendsuseridTable(user.getUserid());	
    		
    		System.out.println("Controller result line 70"+result);
    		return "login";//提交注册信息后返回到登录页面
    	}else if(result=="failed") {
    		return "failed";
    	}
    	
    	return null;
//    	return "login";
    }
    
    @RequestMapping("loginOut")  
    public String loginOut(HttpServletRequest request,HttpServletResponse response) throws Exception{  
        HttpSession session=request.getSession();  
        session.removeAttribute("userid");  
        //request.getRequestDispatcher("/socketChat.jsp").forward(request, response);  
        
        return "login";
    }  
} 