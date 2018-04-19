package com.hisen.service;

import java.util.List;

import com.hisen.entity.User;

public interface UserinfoService {

	User getUserinfoByUserid(String userid);

	String updateUserinfoByUserid(User user);

	List<Integer> findAllFriendByUserid(User user);
	

}
