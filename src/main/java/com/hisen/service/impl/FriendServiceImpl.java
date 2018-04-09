package com.hisen.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisen.dao.FriendDao;
import com.hisen.entity.Friend;
import com.hisen.entity.User;
import com.hisen.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;
	
	@Override
	public Friend getById(long friendId) {
		// TODO Auto-generated method stub
		return friendDao.queryByid(friendId);
	}

	@Override
	public List<Friend> getList(int start,int pageNum) {
		// TODO Auto-generated method stub
		return friendDao.queryAll(start, pageNum);
	}
	
	/*
	 * @METHOD 返回根据friends1 friends2 类似表名的数据查询结果。
	 * @see com.hisen.service.FriendService#getFriendListByUserid(java.lang.String)
	 */
	@Override
	public List<User> getFriendListByUserid(String userid) {
		// TODO 多对多关系数据表的设计
		System.out.println("friendservice==================================friendservice");
		return friendDao.getFriendListByUserid(userid);
	}
	
	@Override
	public int addFriend(Friend friend) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFriend(Friend friend) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFriendById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
