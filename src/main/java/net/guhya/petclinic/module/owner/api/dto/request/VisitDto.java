package net.guhya.petclinic.module.owner.api.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VisitDto {

	private Integer visitId;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private LocalDate date;
	
	@NotEmpty
	private String description;
	
	@Range(min=1)
	private Integer petId;

	public VisitDto() {}
	
	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
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

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

}
