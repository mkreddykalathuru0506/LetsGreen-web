package com.letsGreen.service;



import java.util.List;

import com.letsGreen.entity.Role;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
    Role findRoleByName(String name);
	Role getRoleById(Long id);
	
}
