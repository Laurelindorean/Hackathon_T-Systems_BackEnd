/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IUserDAO;
import com.dto.User;

/**
 * @author Palmira
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<User> listUsers() {
		return iUserDAO.findAll();
	}

	@Override
	public User saveUser(User user) {
		return iUserDAO.save(user);
	}

	@Override
	public User findById(int codigo) {
		return iUserDAO.findById(codigo).get();
	}

	@Override
	public User updateUser(User user) {
		return iUserDAO.save(user);
	}

	@Override
	public void deleteUser(int codigo) {
		iUserDAO.deleteById(codigo);

	}
}
