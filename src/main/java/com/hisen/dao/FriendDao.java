package com.hisen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hisen.entity.Friend;

public interface FriendDao {
  Friend queryByid(long id);
  List<Friend> queryAll(@Param("offset") int offset, @Param("limit") int limit);
  int addFriend(Friend friend);
  int updateFriend(Friend friend);
  int deleteFriendById(long id);
}
