package com.dron.storeAPI.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "hard_disks")
@Data
public class HardDisk {
    private long diskSizeInGB;
}
