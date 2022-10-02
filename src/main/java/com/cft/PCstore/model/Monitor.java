package com.cft.PCstore.model;

import javax.persistence.Entity;

@Entity
public class Monitor extends Product{
    private Double diagonal;

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }
}
