package com.cft.PCstore.model;

import javax.persistence.Entity;

@Entity
public class HardDrive extends Product{
    Integer mbCapacity;

    public Integer getMbCapacity() {
        return mbCapacity;
    }

    public void setMbCapacity(Integer capacityMB) {
        this.mbCapacity = capacityMB;
    }
}
