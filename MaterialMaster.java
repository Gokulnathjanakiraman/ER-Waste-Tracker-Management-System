package com.erapp23.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "processed_waste")
public class MaterialMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materialName;

    private float quantity;

    private float totalQuantity;

    private java.time.LocalDate entryDate;

    public MaterialMaster() {
        this.entryDate = java.time.LocalDate.now(); // default today
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMaterialName() { return materialName; }
    public void setMaterialName(String materialName) { this.materialName = materialName; }

    public float getQuantity() { return quantity; }
    public void setQuantity(float quantity) { this.quantity = quantity; }

    public float getTotalQuantity() { return totalQuantity; }
    public void setTotalQuantity(float totalQuantity) { this.totalQuantity = totalQuantity; }

    public java.time.LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(java.time.LocalDate entryDate) { this.entryDate = entryDate; }
}
