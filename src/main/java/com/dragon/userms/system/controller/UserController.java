package com.dragon.userms.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragon.userms.system.dao.UserDao;
import com.dragon.userms.system.model.User;
import com.dragon.userms.system.repository.UserRepository;

@Controller
@RequestMapping("/system/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/query")
	public String queryList(User search, Model model) {
		List<User> result = userDao.findAll(search);
		model.addAttribute("users", result);
		return "/system/user/list";
	}

	@RequestMapping("/search/{username}")
	public @ResponseBody List<User> searchUser(@PathVariable("username") String username) {
		List<User> result = this.userRepository.findByUserNameContaining(username);

		return result;
	}

	@RequestMapping("/get/{id}")
	public String get(@PathVariable("id") Integer id, Model model) {
		User result = this.userRepository.findOne(id);
		model.addAttribute("user", result);
		return "/system/user/userDetail";
	}

	@RequestMapping("/edit/view")
	public String editView() {
		return "/system/user/addUser";
	}

	@PostMapping("/save")
	public String save(User user) {
		userRepository.save(user);
		return "redirect:/system/user/query";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		userRepository.delete(id);
		return "redirect:/system/user/query";
	}
}