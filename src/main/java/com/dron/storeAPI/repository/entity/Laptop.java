package com.dron.storeAPI.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "laptops")
@Data
public class Laptop extends Product
{
    private int screenSize;
}
