package com.metropolitan.projekat.repository;

import com.metropolitan.projekat.entiteti.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



List<Product> findAll();
    Product findById(long id);
    Product save(Product product);
    void deleteById(long id);
}
