package com.hisen.web;

import com.hisen.entity.Friend;
import com.hisen.entity.User;
import com.hisen.service.FriendService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hisen on 17-4-24.
 */
@Controller
@RequestMapping("/showfriend")
public class FriendController {
	// private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FriendService friendService;

	// @RequestMapping(value = "/list", method = RequestMethod.GET)
	// private String list(Model model) {
	// List<Friend> list = friendService.getList();
	// model.addAttribute("list", list);
	// return "list";// WEB-INF/jsp/"list".jsp
	// }
	@RequestMapping(value = "/friendslist/{userid}", method = RequestMethod.POST)
	@ResponseBody
	public List<User> showAllFriends(@PathVariable("userid")String userid) throws Exception {
		System.out.println("正在请求userid为"+userid+"的好友列表");
//		List<Friend> friendlist = friendService.getList(0, 1000);
		List<User> friendlist = friendService.getFriendListByUserid(userid);
		System.out.println(friendlist);
		return friendlist;

	}

	@RequestMapping(value = "/detail/{friendId}", method = RequestMethod.GET)
	private String detail(@PathVariable("frienId") Long friendId, Model model) {
		Friend friend = friendService.getById(friendId);
		model.addAttribute("friend", friend);
		return "detail";
	}

	 @RequestMapping(value = "/findFriend", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	 @ResponseBody
	 private String findFriend(HttpServletRequest request,HttpServletResponse reponse ,Model model) {
		 //先查找好友是否存在
		 String friendid = request.getParameter("useridfindFriend");
		 
	     return friendService.findFriendById(friendid);
	 }
	 @RequestMapping(value = "/addFriend", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	 @ResponseBody
	 private String addFriend(HttpServletRequest request,HttpServletResponse reponse ,Model model) {
		 
		 String friendid = request.getParameter("founduserid");
		 String userid = request.getParameter("userid");
		 //确认好友是否已经在好友列表中。
		 
	     return friendService.addFriendById(friendid,userid);
	 }
	//
	// @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
	// @ResponseBody
	// private String deleteBookById(@PathVariable("bookId") Long id) {
	// int i = bookService.deleteBookById(id);
	// return i > 0 ? "success" : "error";
	// }
}
