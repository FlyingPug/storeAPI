package com.dron.storeAPI.dto;

import com.dron.storeAPI.repository.entity.DesktopComputer;
import com.dron.storeAPI.repository.entity.Product;
import lombok.Getter;
import lombok.Setter;

/*
 * Dto настольных компьютеров
 */

@Getter
@Setter
public class DesktopComputerDto extends ProductDto {
    private String formFactor;

    @Override
    public Product toProduct() {
        DesktopComputer product = new DesktopComputer();
        copyProperties(product);
        product.setFormFactor(formFactor);
        return product;
    }
}
