package com.cft.PCstore.model;

import javax.persistence.Entity;

@Entity
public class Desktop extends Product{
    private String formFactor;

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
