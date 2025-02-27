package net.guhya.petclinic.module.vet.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class VetSpecialtyKey implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "vet_id")
	private Integer vetId;
	
	@Column(name = "specialty_id")
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
