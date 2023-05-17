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

import com.dto.Role;
import com.service.IRoleService;

/**
 * @author Palmira
 *
 */
@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('admin')") // Only an Admin Role will be able to use these endpoints
public class RoleController {

	@Autowired
	IRoleService roleServiceImpl;

	@GetMapping("/roles")
	public List<Role> listRoles() {
		return roleServiceImpl.listRoles();
	}

	@PostMapping("/roles")
	public ResponseEntity<Role> saveRole(@RequestBody Role role) {
		return ResponseEntity.ok(roleServiceImpl.saveRole(role));
	}

	@GetMapping("/roles/{id}")
	public Role findById(@PathVariable(name = "id") int id) {
		Role role = new Role();
		role = roleServiceImpl.findById(id);
		return role;
	}

	@PutMapping("/roles/{id}")
	public Role updateRole(@PathVariable(name = "id") int id, @RequestBody Role role) {

		Role role_selected = new Role();
		Role role_updated = new Role();
		role_selected = roleServiceImpl.findById(id);
		role_selected.setName(role.getName());

		role_updated = roleServiceImpl.updateRole(role_selected);

		return role_updated;
	}

	@DeleteMapping("/roles/{id}")
	public ResponseEntity<String> deleteRole(@PathVariable(name = "id") int id) {
		roleServiceImpl.deleteRole(id);
		return ResponseEntity.ok("Role deleted");
	}

	// EndPoint to change the role of a user
	@PutMapping("/roles/user/{idUser}")
	public ResponseEntity<String> setAdminByIdUser(@PathVariable int idUser) {
		this.roleServiceImpl.setRoleAdminByIdUser(idUser);
		return ResponseEntity.ok("User set to Admin");
	}

}
