package com.hisen.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisen.dao.UserDao;
import com.hisen.entity.User;
import com.hisen.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public String findUserByUseridandUserpassword(String userid,String userpassword) {
		
		List<User> finduserresult = new ArrayList<User>();
		
		User user;
		finduserresult = userDao.findUserByUseridandUserpassword(userid,userpassword);
		Iterator<User> itrator = finduserresult.iterator();
		if(itrator.hasNext()) {
			user=(User) itrator.next();
			System.out.println("UserServiceImpl中的消息:line:30:userid:"+user.getUserid()+"userpassword:"+user.getUserpassword());

			return "success";
		}else {
			return "failed";
		}
		//TODO NullPointerException when get 0 result from database
		
		
		
		
	}
	

}
