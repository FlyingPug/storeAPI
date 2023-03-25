package com.dron.storeAPI.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "monitors")
@Data
public class Monitor
{
    private int diagonal;
}
