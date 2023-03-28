package com.dron.storeAPI.repository.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("hardDisk")
@Getter
@Setter
public class HardDisk extends Product{
    private long diskSizeInGB; // Объем жесткого диска в гб

    @Override
    public void updateProduct(Product hardDisk)
    {
        super.updateProduct(hardDisk);
        if(hardDisk instanceof  HardDisk)
            this.diskSizeInGB = ((HardDisk)hardDisk).getDiskSizeInGB();
    }

}
