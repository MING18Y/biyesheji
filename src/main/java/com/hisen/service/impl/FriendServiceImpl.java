package com.hisen.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisen.dao.FriendDao;
import com.hisen.entity.Friend;
import com.hisen.entity.User;
import com.hisen.service.FriendService;

import net.sf.json.JSONObject;

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

	@Override
	public String findFriendById(String friendid) {
		// TODO Auto-generated method stub
		JSONObject jsonobject ;
		User result = friendDao.findFriendById(friendid);
		
		jsonobject= JSONObject.fromObject(result);
		
		return jsonobject.toString();
			
		
	}

	@Override
	public String addFriendById(String friendid,String userid) {
		// TODO Auto-generated method stub
		//查找该friend的所有信息;
		User user = friendDao.findFriendByIdAll(friendid); 
		//确认是否已经在自己的好友列表中了；
		List<User> checkresult = friendDao.checkIfexists(friendid,userid);
		System.out.println("checkresult"+checkresult.size());
		if(checkresult.size() == 0) {
			int result = friendDao.addFriendByFriendid(user,userid);
			if(result>=1) {
				return "success";
			}else {
				return "failed";
			}
		}
		else {
			
			return "alreadyExists";
		}
		//System.err.println("Warn:Need attention,method addFriendById:FriendService.java returned null ,it perhaps means this method didnt do anything,please check.");
		//return null;

	}

	

}
