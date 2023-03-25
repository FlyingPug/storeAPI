package com.dron.storeAPI.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

/*
 * В данном случае выбрал стратегию единой таблицы, т.к это должно быть куда лучше, чем иметь таблицу на каждый товар
 */

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
public class Product
{
    @Id
    private Long id;

    private Long serialNumber;
    private Long price;
    private String manufacturer;
    private int quantity;
}
