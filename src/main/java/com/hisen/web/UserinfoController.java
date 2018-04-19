package com.hisen.web;

import com.hisen.entity.User;
import com.hisen.service.UserinfoService;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hisen on 17-4-24.
 */
@Controller
@RequestMapping("/userinfo")
public class UserinfoController {
	@Autowired
	private UserinfoService userinfoService;

	@RequestMapping(value = "/getuserinfo/{userid}", method = RequestMethod.POST)
	@ResponseBody
	public User getUserinfo(@PathVariable("userid")String userid) throws Exception {
		System.out.println("正在请求userid为"+userid+"的用户信息");
//		List<User> friendlist = friendService.getFriendListByUserid(userid);
//		System.out.println(friendlist);
		User userinfo = userinfoService.getUserinfoByUserid(userid);

		return userinfo;

	}
	
	@RequestMapping("/updateuserinfo")
	@ResponseBody
	public User updateUserinfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("updateuserinfo:userid:"+request.getParameter("userid"));
//		List<User> friendlist = friendService.getFriendListByUserid(userid);
//		System.out.println(friendlist);
		
		User user = new User();
		user.setUserid(request.getParameter("userid"));
		user.setUseremail(request.getParameter("useremail"));
		user.setUsersignature(request.getParameter("usersignature"));
		user.setUsernickname(request.getParameter("usernickname"));
	
		System.out.println("正在更新usernickname为"+user.getUsernickname()+"的用户信息");
		//更新用户自己的信息表
		String result = userinfoService.updateUserinfoByUserid(user);
		System.out.println("result："+result);
		//成功后，更新该用户的所有好友信息表
		if (result == "1"||result.equals("1")) {
			
			//查找该用户的所有好友并对好友中自己的信息更改
			List<Integer> allFriend = userinfoService.findAllFriendByUserid(user);
			Iterator<Integer> iterator = allFriend.iterator();
			
			while(iterator.hasNext()) {
				int i = iterator.next();
				if(i == 0) {
					System.out.println("friends"+i+"表更新失败");
					
					return user ;
				}
			}
			System.out.println("全部friends表更新成功");
			
		}
		return user;
	}
	
//	@RequestMapping(value = "/detail/{friendId}", method = RequestMethod.GET)
//	private String detail(@PathVariable("frienId") Long friendId, Model model) {
//		Friend friend = friendService.getById(friendId);
//		model.addAttribute("friend", friend);
//		return "detail";
//	}

}
