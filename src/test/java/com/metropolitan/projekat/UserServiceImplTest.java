package com.metropolitan.projekat;

import com.metropolitan.projekat.entiteti.User;
import com.metropolitan.projekat.repository.UserRepository;
import com.metropolitan.projekat.service.UserService;
import com.metropolitan.projekat.service.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveUser(user);
        assertEquals(user, result);
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(user);
        assertEquals(user, result);
    }

    @Test
    void testDeleteUser() {
        Long id = 1L;
        doNothing().when(userRepository).deleteById(id);

        userService.deleteUser(id);
        verify(userRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetUserById() {
        Long id = 1L;
        User user = new User();
        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        User result = userService.getUserById(id);
        assertEquals(user, result);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(), new User());
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();
        assertEquals(users, result);
    }

    @Test
    void testFindByUsername() {
        String username = "username";
        User user = new User();
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findByUsername(username);
        assertEquals(Optional.of(user), result);
    }
}
