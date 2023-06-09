package net.guhya.petclinic.module.owner.api.dto.request;

import jakarta.validation.constraints.NotEmpty;

public class PetTypeDto {

	private Integer typeId;

	@NotEmpty
	private String name;
	
	public Integer getTypeId() {
		return typeId;
	}

	public void seTypetId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
