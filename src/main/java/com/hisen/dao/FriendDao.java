package com.hisen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hisen.entity.Friend;
import com.hisen.entity.User;

public interface FriendDao {
  Friend queryByid(long id);
  List<Friend> queryAll(@Param("offset") int offset, @Param("limit") int limit);
  List<User> getFriendListByUserid(@Param("userid") String userid);
  int addFriend(Friend friend);
  int updateFriend(Friend friend);
  int deleteFriendById(long id);

}
