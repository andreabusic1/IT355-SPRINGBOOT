package com.metropolitan.projekat.repository;

import com.metropolitan.projekat.entiteti.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User findById(long id);
    User save(User user);
    void deleteById(long id);
    Optional<User> findByUsername(String username);

}
