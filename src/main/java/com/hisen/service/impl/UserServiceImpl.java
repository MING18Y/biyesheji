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

	@Override
	public String findUserByUserid(String userid) {
		List<User> finduserresult = new ArrayList<User>();
		User user;
		finduserresult = userDao.findUserByUserid(userid);
		Iterator<User> itrator = finduserresult.iterator();
		if(itrator.hasNext()) {
			user=(User) itrator.next();
			System.out.println("找到了userid为："+user.getUserid()+"的用户，当前查询userid已存在");
			return "success";
		}else {
			System.out.println("没有找到对应的userid");
			return "continue";
		}
	}

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("开始往数据表userinfo里面提交新的用户信息 userserviceimpl");
		int resultUser;
		resultUser = userDao.addUser(user);
		//resultUser 为1 时表示添加成功
		System.out.println("resultUser value:"+resultUser);
		
		if(resultUser==1) {
			return "success";
		}
		
		return "failed";
	}

	@Override
	public String createFriendsuseridTable(String userid) {
		// TODO Auto-generated method stub
		int resultCreate;
		resultCreate = userDao.createFriendsuseridTable(userid);
		if(resultCreate == 0) {
			System.out.println("创建新用户的表成功");
			return "success";
		}
		
		System.out.println("创建新用户的表失败：line:79:UserServiceImpl");
		return "failed";
	}
	
	

}
