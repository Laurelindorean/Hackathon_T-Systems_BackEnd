/**
 * 
 */
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Utils.Utils;
import com.dto.User;
import com.service.UserServiceImpl;

/**
 * @author Palmira
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/users")
	@PreAuthorize("hasRole('admin')")
	public List<User> listUser() {
		return userServiceImpl.listUsers();
	}

	@PostMapping("/users")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok(userServiceImpl.saveUser(user));
	}

	@GetMapping("/users/{id}")
	public User findById(@PathVariable(name = "id") int id) {
		// this endpoint won't work unless the idUser = codigo
		if (Utils.getUserDetails().getId() != id) {
			throw new RuntimeException("You're not allowed to see this User");
		}
		return userServiceImpl.findById(id);
	}

	// This endpoint will return any user by id and it will be only accesible by
	// admins
	@GetMapping("/users/admin/{id}")
	@PreAuthorize("hasRole('admin')")
	public User findUsersById(@PathVariable(name = "id") int id) {
		return userServiceImpl.findById(id);
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(name = "id") int id, @RequestBody User user) {

		if (Utils.getUserDetails().getId() != id) {
			throw new RuntimeException("You're not allowed to update this User");
		}
		
		User user_selected = new User();
		User user_updated = new User();
		user_selected = userServiceImpl.findById(id);
		user_selected.setName(user.getName());
		user_selected.setPassword(user.getPassword());
		user_updated = userServiceImpl.updateUser(user_selected);
		return user_updated;
	}

	@PutMapping("/users/update/{id}")
	@PreAuthorize("hasRole('admin')")
	public User updateUserByAdmin(@PathVariable(name = "id") int id, @RequestBody User user) {

		User user_selected = new User();
		User user_updated = new User();
		user_selected = userServiceImpl.findById(id);
		user_selected.setName(user.getName());
		user_selected.setPassword(user.getPassword());

		user_updated = userServiceImpl.updateUser(user_selected);
		return user_updated;
	}

	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<String> deleteUser(@PathVariable(name = "id") int id) {
		userServiceImpl.deleteUser(id);
		return ResponseEntity.ok("User deleted");
	}

}
