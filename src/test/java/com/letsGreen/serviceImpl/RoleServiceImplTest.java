package com.letsGreen.serviceImpl;

import com.letsGreen.entity.Role;
import com.letsGreen.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleServiceImpl roleService;

    private Role role;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        role = new Role();
        role.setId(1L);
        role.setName("Admin");
    }

    @Test
    void testCreateRole() {
        when(roleRepository.save(any(Role.class))).thenReturn(role);

        Role createdRole = roleService.createRole(role);

        assertNotNull(createdRole);
        assertEquals(1L, createdRole.getId());
        assertEquals("Admin", createdRole.getName());
        verify(roleRepository, times(1)).save(any(Role.class));
    }

    @Test
    void testGetRoleById() {
        when(roleRepository.findById(anyLong())).thenReturn(Optional.of(role));

        Role foundRole = roleService.getRoleById(1L);

        assertNotNull(foundRole);
        assertEquals(1L, foundRole.getId());
        assertEquals("Admin", foundRole.getName());
        verify(roleRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetRoleByIdNotFound() {
        when(roleRepository.findById(anyLong())).thenReturn(Optional.empty());

        Role foundRole = roleService.getRoleById(1L);

        assertNull(foundRole);
        verify(roleRepository, times(1)).findById(anyLong());
    }

    @Test
    void testGetAllRoles() {
        List<Role> roles = Arrays.asList(role);
        when(roleRepository.findAll()).thenReturn(roles);

        List<Role> allRoles = roleService.getAllRoles();

        assertNotNull(allRoles);
        assertEquals(1, allRoles.size());
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    void testUpdateRole() {
        when(roleRepository.findById(anyLong())).thenReturn(Optional.of(role));
        when(roleRepository.save(any(Role.class))).thenReturn(role);

        Role updatedRole = roleService.updateRole(1L, role);

        assertNotNull(updatedRole);
        assertEquals(1L, updatedRole.getId());
        assertEquals("Admin", updatedRole.getName());
        verify(roleRepository, times(1)).findById(anyLong());
        verify(roleRepository, times(1)).save(any(Role.class));
    }

    @Test
    void testUpdateRoleNotFound() {
        when(roleRepository.findById(anyLong())).thenReturn(Optional.empty());

        Role updatedRole = roleService.updateRole(1L, role);

        assertNull(updatedRole);
        verify(roleRepository, times(1)).findById(anyLong());
        verify(roleRepository, never()).save(any(Role.class));
    }

    @Test
    void testDeleteRole() {
        doNothing().when(roleRepository).deleteById(anyLong());

        roleService.deleteRole(1L);

        verify(roleRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void testFindRoleByName() {
        when(roleRepository.findByName(anyString())).thenReturn(role);

        Role foundRole = roleService.findRoleByName("Admin");

        assertNotNull(foundRole);
        assertEquals(1L, foundRole.getId());
        assertEquals("Admin", foundRole.getName());
        verify(roleRepository, times(1)).findByName(anyString());
    }

    @Test
    void testFindRoleByNameNotFound() {
        when(roleRepository.findByName(anyString())).thenReturn(null);

        Role foundRole = roleService.findRoleByName("Admin");

        assertNull(foundRole);
        verify(roleRepository, times(1)).findByName(anyString());
    }
}
