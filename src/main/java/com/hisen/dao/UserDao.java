package com.hisen.dao;

import java.util.List;

import com.hisen.entity.User;

public interface UserDao {
	List<User> findUserByUseridandUserpassword(String userid,String userpassword);

}
