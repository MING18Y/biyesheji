package com.hisen.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisen.dao.FriendDao;
import com.hisen.entity.Friend;
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
