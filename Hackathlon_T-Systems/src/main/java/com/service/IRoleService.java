/**
 * 
 */
package com.service;

import java.util.List;

import com.dto.Role;

/**
 * @author Palmira
 *
 */
public interface IRoleService {
	
	public List<Role> listRoles(); 

	public Role saveRole(Role role); 

	public Role findById(int id); 

	public Role updateRole(Role role); 

	public void deleteRole(int id);
	
	public Role findByRole(String role);

	public void setRoleAdminByIdUser(int idUser);

}
