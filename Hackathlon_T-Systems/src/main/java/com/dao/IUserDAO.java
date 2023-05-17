/**
 * 
 */
package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.User;

/**
 * @author Palmira
 *
 */
public interface IUserDAO extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);

}
