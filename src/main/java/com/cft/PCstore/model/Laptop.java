package com.cft.PCstore.model;

import javax.persistence.Entity;

@Entity
public class Laptop extends Product {
    private Double size;

    public Double getSize() {
        return size;
    }

    public void setSize(Double diagonal) {
        this.size = diagonal;
    }
}
