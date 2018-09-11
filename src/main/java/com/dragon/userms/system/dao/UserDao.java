package com.dragon.userms.system.dao;

import java.util.List;

import com.dragon.userms.system.model.User;

public interface UserDao {

	public List<User> findAll(User user);
}
