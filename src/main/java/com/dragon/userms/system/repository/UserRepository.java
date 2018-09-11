/**
 * 
 */
package com.dragon.userms.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dragon.userms.system.model.User;

/**
 * @author Kevin
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String userName);

	public void delete(Integer id);

	public List<User> findByUserNameContaining(String userName);

	public User findByUserNameAndPassword(String userName, String password);

}
