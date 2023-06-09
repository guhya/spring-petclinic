package net.guhya.petclinic.module.vet.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("VetSpecialty")
public class VetSpecialtyWithNameDto {
	
	@JsonIgnore
	private Integer vetId;
	private Integer specialtyId;
	private String specialtyName;

	public VetSpecialtyWithNameDto(Integer vetId, Integer specialtyId, String specialtyName) {
		this.vetId = vetId;
		this.specialtyId = specialtyId;
		this.specialtyName = specialtyName;
	}

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

	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}	
		
}
