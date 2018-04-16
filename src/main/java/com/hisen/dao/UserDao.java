package com.hisen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hisen.entity.User;

public interface UserDao {
	List<User> findUserByUseridandUserpassword(String userid,String userpassword);
	List<User> findUserByUserid(String userid);
	//添加用户
	int addUser(User user);
	//为指定的用户创建其对应的好友表
	int createFriendsuseridTable(@Param(value="userid") String userid);

}
