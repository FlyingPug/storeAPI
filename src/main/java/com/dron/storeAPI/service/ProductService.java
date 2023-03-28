package com.dron.storeAPI.service;

import com.dron.storeAPI.repository.entity.Product;

import java.util.List;

public interface ProductService {
    /*
     * добавление товара в базу данных
     */
    Product addProduct(Product product);

    /*
     * обновление данных о товаре в базе данных
     */
    Product updateProduct(Long id, Product product);

    /*
     * получение товара по id
     */
    Product getProductById(Long id);

    /*
     * получение товара по типу
     */
    List<Product> getProductsByType(String type);

    /*
     * удаление товара
     */
    void deleteProduct(Long id);
}
