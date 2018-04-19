package com.hisen.service.impl;

import com.hisen.dao.UserinfoDao;
import com.hisen.entity.User;
import com.hisen.service.UserinfoService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hisen on 17-4-24.
 */
@Service
public class UserinfoServiceImpl implements UserinfoService {
	@Autowired
	private UserinfoDao userinfoDao;


	@Override
	public User getUserinfoByUserid(String userid) {
		
		//返回了user对象
		return userinfoDao.getUserinfoByUserid(userid);
	}


	@Override
	public String updateUserinfoByUserid(User user) {
		String result = Integer.toString(userinfoDao.updateUserinfoByUserid(user));
		return result;
	}


	@Override
	public List<Integer> findAllFriendByUserid(User user) {
		// TODO Auto-generated method stub
		List<Integer> modifyResult = new ArrayList<Integer>();
		List<String> allFriend = new ArrayList<String>();
		allFriend = userinfoDao.findAllFriendByUserid(user.getUserid());
		Iterator<String> iterator = allFriend.iterator();
		
		while(iterator.hasNext()) {
			String friendiditerator = iterator.next();
			modifyResult.add(userinfoDao.modifyFriendsTableByUseridFriendid(user,friendiditerator));
		}
//		if(iterator.hasNext()) {
//			System.out.println(iterator.hasNext());
//			System.out.println(iterator.next());
//		}
		return modifyResult;
		
	}

 
}

