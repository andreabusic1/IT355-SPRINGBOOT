package com.metropolitan.projekat.service.serviceimpl;


import com.metropolitan.projekat.entiteti.UserAddress;
import com.metropolitan.projekat.repository.UserAddressRepository;
import com.metropolitan.projekat.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public UserAddress saveUserAddress(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public UserAddress updateUserAddress(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public void deleteUserAddress(Long id) {
        userAddressRepository.deleteById(id);
    }

    @Override
    public UserAddress getUserAddressById(int id) {
        return userAddressRepository.findById(id);
    }

    @Override
    public List<UserAddress> getAllUserAddresses() {
        return userAddressRepository.findAll();
    }
}
