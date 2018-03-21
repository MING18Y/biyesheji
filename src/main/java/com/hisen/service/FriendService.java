package com.hisen.service;

import java.util.List;

import com.hisen.entity.Friend;

public interface FriendService {
	
  Friend getById(long friendId);
  //  List<Book> getList(int start, int pageNum);
  List<Friend> getList(int start,int pageNum);
  int addFriend(Friend friend);
  int updateFriend(Friend friend);
  int deleteFriendById(long id);
		

}
