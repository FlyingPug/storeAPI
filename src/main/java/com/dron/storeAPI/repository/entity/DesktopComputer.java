package com.dron.storeAPI.repository.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("desktopComputer")
@Getter
@Setter
public class DesktopComputer extends Product
{
    private String formFactor;

    @Override
    public void updateProduct(Product desktopComputer)
    {
        super.updateProduct(desktopComputer);
        if(desktopComputer instanceof  DesktopComputer)
            this.formFactor = ((DesktopComputer)desktopComputer).getFormFactor();
    }
}
