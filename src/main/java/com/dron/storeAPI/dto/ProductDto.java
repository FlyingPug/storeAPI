package com.dron.storeAPI.dto;

import com.dron.storeAPI.repository.entity.Product;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

/*
 * Dto, отвечающий за общий тип товаров
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LaptopDto.class, name = "laptop"),
        @JsonSubTypes.Type(value = MonitorDto.class, name = "monitor"),
        @JsonSubTypes.Type(value = HardDiskDto.class, name = "hardDisk"),
        @JsonSubTypes.Type(value = DesktopComputerDto.class, name = "desktopComputer")
})
@Getter
@Setter
public class ProductDto {
    protected Long serialNumber;
    protected Long price;
    protected String manufacturer;
    protected int quantity;

    protected String type;

    public Product toProduct() {
        Product product = new Product();
        copyProperties(product);
        return product;
    }

    protected void copyProperties(Product toCopy) {
        toCopy.setType(type);
        toCopy.setPrice(price);
        toCopy.setManufacturer(manufacturer);
        toCopy.setSerialNumber(serialNumber);
        toCopy.setQuantity(quantity);
    }
}
