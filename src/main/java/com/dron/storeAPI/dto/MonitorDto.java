package com.dron.storeAPI.dto;

import com.dron.storeAPI.repository.entity.Monitor;
import com.dron.storeAPI.repository.entity.Product;
import lombok.Getter;
import lombok.Setter;

/*
 * Dto, отвечающий за мониторы
 */

@Getter
@Setter
public class MonitorDto extends ProductDto {
    private int diagonal;

    @Override
    public Product toProduct() {
        Monitor product = new Monitor();
        copyProperties(product);
        product.setDiagonal(diagonal);
        return product;
    }
}
