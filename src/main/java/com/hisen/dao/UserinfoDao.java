package com.hisen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hisen.entity.User;

public interface UserinfoDao {

	User getUserinfoByUserid(@Param("userid")String userid);

	int updateUserinfoByUserid(User user);

	List<String> findAllFriendByUserid(@Param("userid") String userid);

	int modifyFriendsTableByUseridFriendid(@Param("user")User user, @Param("friendiditerator")String friendiditerator);

	

}
