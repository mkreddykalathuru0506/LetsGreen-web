package com.letsGreen.controller;

import com.letsGreen.entity.User;
import com.letsGreen.service.UserService;
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

class UserControllerTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	private User user;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		user = new User();
		user.setUserId((long) 123);
		user.setName("John Doe");
		user.setEmail("john.doe@example.com");
		// Initialize other fields if necessary
	}

	@Test
	void testCreateUser() {
		when(userService.createUser(any(User.class))).thenReturn(user);

		ResponseEntity<String> response = userController.createUser(user);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals("User created with ID: " + user.getUserId(), response.getBody());
		verify(userService, times(1)).createUser(any(User.class));
	}

	@Test
	void testGetAllUsers() {
		List<User> userList = Arrays.asList(user);
		when(userService.getAllUsers()).thenReturn(userList);

		ResponseEntity<String> response = userController.getAllUsers();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("All Users: " + userList.toString(), response.getBody());
		verify(userService, times(1)).getAllUsers();
	}

	@Test
	void testUpdateUser() {
		when(userService.updateUser(anyLong(), any(User.class))).thenReturn(user);

		ResponseEntity<String> response = userController.updateUser(1L, user);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("User updated: " + user.toString(), response.getBody());
		verify(userService, times(1)).updateUser(anyLong(), any(User.class));
	}

	@Test
	void testUpdateUserNotFound() {
		when(userService.updateUser(anyLong(), any(User.class))).thenReturn(null);

		ResponseEntity<String> response = userController.updateUser(1L, user);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("User not found", response.getBody());
	}

	@Test
	void testDeleteUser() {
		doNothing().when(userService).deleteUser(anyLong());

		ResponseEntity<String> response = userController.deleteUser(1L);

		assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
		assertEquals("User deleted", response.getBody());
		verify(userService, times(1)).deleteUser(anyLong());
	}
}
