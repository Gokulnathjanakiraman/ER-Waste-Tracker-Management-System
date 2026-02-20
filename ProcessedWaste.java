package com.erapp23.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "processed_waste")
public class ProcessedWaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String materialName;
    private float quantity;
    private float totalQuantity;

    private LocalDate entryDate = LocalDate.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMaterialName() { return materialName; }
    public void setMaterialName(String materialName) { this.materialName = materialName; }

    public float getQuantity() { return quantity; }
    public void setQuantity(float quantity) { this.quantity = quantity; }

    public float getTotalQuantity() { return totalQuantity; }
    public void setTotalQuantity(float totalQuantity) { this.totalQuantity = totalQuantity; }

    public LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }
}
