/**
 * 
 */
package com.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dto.Role;

/**
 * @author Palmira
 *
 */
public interface IRoleDAO extends JpaRepository<Role, Integer>{
	
	public Optional<Role> findByName(String name);

}
