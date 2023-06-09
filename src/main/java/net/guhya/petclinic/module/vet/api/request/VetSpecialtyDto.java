package net.guhya.petclinic.module.vet.api.request;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("VetSpecialty")
public class VetSpecialtyDto {
	
	private Integer vetId;
	private Integer specialtyId;
	private Integer specialtyName;

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

	public Integer getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(Integer specialtyName) {
		this.specialtyName = specialtyName;
	}	
		
}
