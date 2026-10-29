
package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getActiveProducts() {
        return productRepository.findByActiveTrue();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
