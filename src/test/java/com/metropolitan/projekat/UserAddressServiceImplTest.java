package com.metropolitan.projekat;

import com.metropolitan.projekat.entiteti.UserAddress;
import com.metropolitan.projekat.repository.UserAddressRepository;
import com.metropolitan.projekat.service.UserAddressService;
import com.metropolitan.projekat.service.serviceimpl.UserAddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserAddressServiceImplTest {

    @Mock
    private UserAddressRepository userAddressRepository;

    @InjectMocks
    private UserAddressServiceImpl userAddressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUserAddress() {
        UserAddress userAddress = new UserAddress();
        when(userAddressRepository.save(userAddress)).thenReturn(userAddress);

        UserAddress result = userAddressService.saveUserAddress(userAddress);
        assertEquals(userAddress, result);
    }

    @Test
    void testUpdateUserAddress() {
        UserAddress userAddress = new UserAddress();
        when(userAddressRepository.save(userAddress)).thenReturn(userAddress);

        UserAddress result = userAddressService.updateUserAddress(userAddress);
        assertEquals(userAddress, result);
    }

    @Test
    void testDeleteUserAddress() {
        Long id = 1L;
        doNothing().when(userAddressRepository).deleteById(id);

        userAddressService.deleteUserAddress(id);
        verify(userAddressRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetUserAddressById() {
        int id = 1;
        UserAddress userAddress = new UserAddress();
        when(userAddressRepository.findById(id)).thenReturn(userAddress);

        UserAddress result = userAddressService.getUserAddressById(id);
        assertEquals(userAddress, result);
    }

    @Test
    void testGetAllUserAddresses() {
        List<UserAddress> userAddresses = Arrays.asList(new UserAddress(), new UserAddress());
        when(userAddressRepository.findAll()).thenReturn(userAddresses);

        List<UserAddress> result = userAddressService.getAllUserAddresses();
        assertEquals(userAddresses, result);
    }
}
