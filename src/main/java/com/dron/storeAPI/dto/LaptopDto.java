package com.dron.storeAPI.dto;

import com.dron.storeAPI.repository.entity.Laptop;
import com.dron.storeAPI.repository.entity.Product;
import lombok.Getter;
import lombok.Setter;

/*
 * Dto для ноутбуков
 */

@Getter
@Setter
public class LaptopDto extends ProductDto {
    private int size;

    @Override
    public Product toProduct() {
        Laptop product = new Laptop();
        copyProperties(product);
        product.setSize(size);
        return product;
    }
}
