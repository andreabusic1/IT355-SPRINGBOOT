package com.metropolitan.projekat.controller;

import com.metropolitan.projekat.entiteti.UserAddress;
import com.metropolitan.projekat.service.UserAddressService;
import com.metropolitan.projekat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/userAddresses")
public class UserAddressController {

   final UserAddressService userAddressService;

    @PostMapping
    public ResponseEntity<UserAddress> createUserAddress(@RequestBody UserAddress userAddress) {
        UserAddress savedUserAddress = userAddressService.saveUserAddress(userAddress);
        return ResponseEntity.ok(savedUserAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAddress> updateUserAddress(@PathVariable int id, @RequestBody UserAddress userAddress) {
        userAddress.setId(id);
        UserAddress updatedUserAddress = userAddressService.updateUserAddress(userAddress);
        return ResponseEntity.ok(updatedUserAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserAddress(@PathVariable Long id) {
        userAddressService.deleteUserAddress(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress> getUserAddressById(@PathVariable int id) {
        UserAddress userAddress = userAddressService.getUserAddressById(id);
        return ResponseEntity.ok(userAddress);
    }

    @GetMapping
    public ResponseEntity<List<UserAddress>> getAllUserAddresses() {
        List<UserAddress> userAddresses = userAddressService.getAllUserAddresses();
        return ResponseEntity.ok(userAddresses);
    }
}
