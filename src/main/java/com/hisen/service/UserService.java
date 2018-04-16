package com.hisen.service;

import com.hisen.entity.User;

public interface UserService {
	
	String findUserByUseridandUserpassword(String userid,String userpassword);

	String findUserByUserid(String userid);

	String addUser(User user);

	String createFriendsuseridTable(String userid);

}
