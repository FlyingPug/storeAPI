package com.dron.storeAPI.repository.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("laptop")
@Getter
@Setter
public class Laptop extends Product {
    private int size; // Размер ноутбука

    @Override
    public void updateProduct(Product laptop) {
        super.updateProduct(laptop);
        if (laptop instanceof Laptop)
            this.size = ((Laptop) laptop).getSize();
    }
}
