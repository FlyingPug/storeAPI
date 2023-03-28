package com.dron.storeAPI.dto;

import com.dron.storeAPI.repository.entity.HardDisk;
import com.dron.storeAPI.repository.entity.Product;
import lombok.Getter;
import lombok.Setter;

/*
 * Dto для жестких дисков
 */

@Getter
@Setter
public class HardDiskDto extends ProductDto {
    private long diskSizeInGB;

    @Override
    public Product toProduct() {
        HardDisk product = new HardDisk();
        copyProperties(product);
        product.setDiskSizeInGB(diskSizeInGB);
        return product;
    }
}
