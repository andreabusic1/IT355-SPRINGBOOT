package com.metropolitan.projekat.service;

import com.metropolitan.projekat.entiteti.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    Product createProduct(Product product);
    Product updateProduct(int id, Product product);
    void deleteProduct(Long id);
}
