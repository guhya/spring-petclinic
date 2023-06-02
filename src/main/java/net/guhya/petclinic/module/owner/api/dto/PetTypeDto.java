package net.guhya.petclinic.module.owner.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PetType")
public class PetTypeDto {

	@JsonProperty("name")
	private String name;

	@JsonProperty("typeId")
	@JsonIgnore
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
