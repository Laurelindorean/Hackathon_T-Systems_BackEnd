/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IRoleDAO;
import com.dto.Role;
import com.dto.User;

/**
 * @author Palmira
 *
 */
@Service
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	IRoleDAO iRoleDAO;
	@Autowired
	IUserService userService;

	@Override
	public List<Role> listRoles() {
		return iRoleDAO.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		return iRoleDAO.save(role);
	}

	@Override
	public Role findById(int codigo) {
		return iRoleDAO.findById(codigo).get();
	}

	@Override
	public Role updateRole(Role role) {
		return iRoleDAO.save(role);
	}

	@Override
	public void deleteRole(int codigo) {
		iRoleDAO.deleteById(codigo);

	}

	@Override
	public Role findByRole(String role) {
		return iRoleDAO.findByName(role).get();
	}

	@Override
	public void setRoleAdminByIdUser(int idUser) {

		User userEntity = this.userService.findById(idUser);
		userEntity.setRole(this.iRoleDAO.findByName("ROLE_admin").get());
		this.userService.updateUser(userEntity);
	}

}
