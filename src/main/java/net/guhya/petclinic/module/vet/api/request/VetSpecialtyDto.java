package net.guhya.petclinic.module.vet.api.request;

import jakarta.validation.constraints.NotEmpty;

public class VetSpecialtyDto {
	
	private Integer vetId;
	
	@NotEmpty
	private Integer specialtyId;

	public Integer getVetId() {
		return vetId;
	}

	public void setVetId(Integer vetId) {
		this.vetId = vetId;
	}

	public Integer getSpecialtyId() {
		return specialtyId;
	}

	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}

}
