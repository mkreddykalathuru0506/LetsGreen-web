package com.letsGreen.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.letsGreen.entity.User;
import com.letsGreen.repository.UserRepository;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserId(1L);
        user.setName("Test User");
        // Set other properties as needed
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser);
        assertEquals(user.getUserId(), createdUser.getUserId());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        User foundUser = userService.getUserById(1L);
        assertNotNull(foundUser);
        assertEquals(user.getUserId(), foundUser.getUserId());
        verify(userRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        User foundUser = userService.getUserById(1L);
        assertNull(foundUser);
        verify(userRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);
        List<User> userList = userService.getAllUsers();
        assertNotNull(userList);
        assertEquals(1, userList.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateUser() {
        when(userRepository.existsById(anyLong())).thenReturn(true);
        when(userRepository.save(any(User.class))).thenReturn(user);
        User updatedUser = userService.updateUser(1L, user);
        assertNotNull(updatedUser);
        assertEquals(user.getUserId(), updatedUser.getUserId());
        verify(userRepository, times(1)).existsById(anyLong());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testUpdateUserNotFound() {
        when(userRepository.existsById(anyLong())).thenReturn(false);
        User updatedUser = userService.updateUser(1L, user);
        assertNull(updatedUser);
        verify(userRepository, times(1)).existsById(anyLong());
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(userRepository).deleteById(anyLong());
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(anyLong());
    }
}
