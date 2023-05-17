/**
 * 
 */
package com.service;

import java.util.List;

import com.dto.User;

/**
 * @author Palmira
 *
 */
public interface IUserService {
	
	public List<User> listUsers(); 

	public User saveUser(User user); 

	public User findById(int id); 

	public User updateUser(User user); 

	public void deleteUser(int id);

}
