package net.guhya.petclinic.module.owner.projection;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Visit")
public class VisitWithPetDto {

	private Integer visitId;
	private Integer petId;
	private String petName;
	private LocalDate date;
	private String description;

	public VisitWithPetDto(Integer visitId, Integer petId, String petName, LocalDate date, String description) {
		super();
		this.visitId = visitId;
		this.petId = petId;
		this.petName = petName;
		this.date = date;
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

}
