package com.dron.storeAPI.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/*
 * В данном случае выбрал стратегию единой таблицы, т.к это должно быть куда эффективней, чем иметь таблицу на каждый товар
 */

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", insertable = false, updatable = false)
    protected String type;
    private Long serialNumber; // серийный номер
    private Long price;  // цена
    private String manufacturer;  // производитель
    private int quantity;  // количество товара

    public void updateProduct(Product product) {
        this.serialNumber = product.serialNumber;
        this.price = product.price;
        this.manufacturer = product.manufacturer;
        this.quantity = product.quantity;
    }
}
