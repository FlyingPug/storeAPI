package com.dron.storeAPI.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "desktop_computers")
@Data
public class DesktopComputer extends Product
{
    private String formFactor;
}
