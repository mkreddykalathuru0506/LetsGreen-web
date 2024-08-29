package com.letsGreen.controller;

import com.letsGreen.entity.Role;
import com.letsGreen.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class RoleControllerTest {

    @Mock
    private RoleService roleService;

    @InjectMocks
    private RoleController roleController;

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
        when(roleService.createRole(any(Role.class))).thenReturn(role);

        ResponseEntity<Role> response = roleController.createRole(role);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(role, response.getBody());
        verify(roleService, times(1)).createRole(any(Role.class));
    }

    @Test
    void testGetRoleById() {
        when(roleService.getRoleById(anyLong())).thenReturn(role);

        ResponseEntity<Role> response = roleController.getRoleById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(role, response.getBody());
        verify(roleService, times(1)).getRoleById(anyLong());
    }

    @Test
    void testGetRoleByIdNotFound() {
        when(roleService.getRoleById(anyLong())).thenReturn(null);

        ResponseEntity<Role> response = roleController.getRoleById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testGetAllRoles() {
        List<Role> roleList = Arrays.asList(role);
        when(roleService.getAllRoles()).thenReturn(roleList);

        ResponseEntity<List<Role>> response = roleController.getAllRoles();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(roleList, response.getBody());
        verify(roleService, times(1)).getAllRoles();
    }

    @Test
    void testUpdateRole() {
        when(roleService.updateRole(anyLong(), any(Role.class))).thenReturn(role);

        ResponseEntity<Role> response = roleController.updateRole(1L, role);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(role, response.getBody());
        verify(roleService, times(1)).updateRole(anyLong(), any(Role.class));
    }

    @Test
    void testUpdateRoleNotFound() {
        when(roleService.updateRole(anyLong(), any(Role.class))).thenReturn(null);

        ResponseEntity<Role> response = roleController.updateRole(1L, role);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testDeleteRole() {
        doNothing().when(roleService).deleteRole(anyLong());

        ResponseEntity<Void> response = roleController.deleteRole(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(roleService, times(1)).deleteRole(anyLong());
    }
    
    @Test
    void testGetRoleByName() {
        when(roleService.findRoleByName(anyString())).thenReturn(role);

        ResponseEntity<Role> response = roleController.getRoleByName("Admin");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(role, response.getBody());
        verify(roleService, times(1)).findRoleByName(anyString());
    }

    @Test
    void testGetRoleByNameNotFound() {
        when(roleService.findRoleByName(anyString())).thenReturn(null);

        ResponseEntity<Role> response = roleController.getRoleByName("Admin");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}
