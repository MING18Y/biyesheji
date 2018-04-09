package com.hisen.web;

import com.hisen.entity.Friend;
import com.hisen.entity.User;
import com.hisen.service.FriendService;

import java.util.List;

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

	// @RequestMapping(value = "/add", method = RequestMethod.POST, produces =
	// "text/plain;charset=UTF-8")
	// @ResponseBody
	// private String add(Book book) {
	// Book hasBook = bookService.getById(book.getBookId());
	// int i = -2;
	// if (hasBook == null) {
	// i = bookService.addBook(book);
	// }
	// return i > 0 ? "success" : "error";
	// }
	//
	// @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
	// @ResponseBody
	// private String deleteBookById(@PathVariable("bookId") Long id) {
	// int i = bookService.deleteBookById(id);
	// return i > 0 ? "success" : "error";
	// }
}
