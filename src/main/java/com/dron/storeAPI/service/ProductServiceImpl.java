package com.dron.storeAPI.service;

import com.dron.storeAPI.exception.ProductNotFound;
import com.dron.storeAPI.repository.ProductRepository;
import com.dron.storeAPI.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * Сервис, для
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isEmpty()) throw new ProductNotFound("Product was not found");

        existingProduct.get().updateProduct(product);

        return productRepository.save(existingProduct.get());
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new ProductNotFound("Product was not found");
        productRepository.delete(product.get());
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new ProductNotFound("Product was not found");
        return product.get();
    }

    @Override
    public List<Product> getProductsByType(String type) {
        return productRepository.findAllByType(type);
    }
}
