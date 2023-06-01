package org.springframework.samples.petclinic.owner.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PetType")
public class PetTypeDto {

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private Integer id;

}
