package com.letsGreen.serviceImpl;


import com.letsGreen.entity.Role;
import com.letsGreen.repository.RoleRepository;
import com.letsGreen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Optional<Role> existingRole = roleRepository.findById(id);
        if (existingRole.isPresent()) {
            Role updatedRole = existingRole.get();
            updatedRole.setName(role.getName());
            return roleRepository.save(updatedRole);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

	

	
}
