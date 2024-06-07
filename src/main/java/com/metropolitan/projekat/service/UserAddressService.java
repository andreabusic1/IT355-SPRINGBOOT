package com.metropolitan.projekat.service;


import com.metropolitan.projekat.entiteti.UserAddress;

import java.util.List;

public interface UserAddressService {
    UserAddress saveUserAddress(UserAddress userAddress);
    UserAddress updateUserAddress(UserAddress userAddress);
    void deleteUserAddress(Long id);
    UserAddress getUserAddressById(int id);
    List<UserAddress> getAllUserAddresses();
}
