package com.erapp23.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailyWaste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float incomingDry;
    private float incomingWet;
    private float rejectWaste;
    private float totalWaste;
    private LocalDate entryDate = LocalDate.now();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getIncomingDry() {
		return incomingDry;
	}
	public void setIncomingDry(float incomingDry) {
		this.incomingDry = incomingDry;
	}
	public float getIncomingWet() {
		return incomingWet;
	}
	public void setIncomingWet(float incomingWet) {
		this.incomingWet = incomingWet;
	}
	public float getRejectWaste() {
		return rejectWaste;
	}
	public void setRejectWaste(float rejectWaste) {
		this.rejectWaste = rejectWaste;
	}
	public float getTotalWaste() {
		return totalWaste;
	}
	public void setTotalWaste(float totalWaste) {
		this.totalWaste = totalWaste;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

    // getters and setters
}
