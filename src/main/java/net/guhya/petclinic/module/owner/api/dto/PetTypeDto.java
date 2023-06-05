package net.guhya.petclinic.module.owner.api.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PetType")
public class PetTypeDto {

	private String name;
	private Integer typeId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void seTypetId(Integer typeId) {
		this.typeId = typeId;
	}

}
