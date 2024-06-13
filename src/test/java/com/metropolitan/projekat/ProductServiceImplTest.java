package com.metropolitan.projekat;

import com.metropolitan.projekat.entiteti.Product;
import com.metropolitan.projekat.repository.ProductRepository;
import com.metropolitan.projekat.service.ProductService;
import com.metropolitan.projekat.service.serviceimpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();
        assertEquals(products, result);
    }

    @Test
    void testGetProductById() {
        int id = 1;
        Product product = new Product();
        when(productRepository.findById(id)).thenReturn(product);

        Product result = productService.getProductById(id);
        assertEquals(product, result);
    }

    @Test
    void testCreateProduct() {
        Product product = new Product();
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);
        assertEquals(product, result);
    }

    @Test
    void testUpdateProduct() {
        int id = 1;
        Product product = new Product();
        product.setName("New Name");
        product.setDescription("New Description");
        product.setPrice(100.0);
        product.setStock(10);
        product.setImageUrl("http://image.url");

        when(productRepository.findById(id)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.updateProduct(id, product);
        assertEquals(product, result);
    }

    @Test
    void testDeleteProduct() {
        Long id = 1L;
        doNothing().when(productRepository).deleteById(id);

        productService.deleteProduct(id);
        verify(productRepository, times(1)).deleteById(id);
    }
}
