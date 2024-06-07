package com.metropolitan.projekat.repository;

import com.metropolitan.projekat.entiteti.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
    List<UserAddress> findAll();
    UserAddress findById(long id);
    UserAddress save(UserAddress userAddress);
    void deleteById(long id);
}
