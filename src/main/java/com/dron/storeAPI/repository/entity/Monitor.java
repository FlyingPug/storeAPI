package com.dron.storeAPI.repository.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("monitor")
@Getter
@Setter
public class Monitor extends Product {
    private int diagonal;  // Диагональ экрана

    @Override
    public void updateProduct(Product monitor) {
        super.updateProduct(monitor);
        if (monitor instanceof Monitor)
            this.diagonal = ((Monitor) monitor).getDiagonal();
    }
}
