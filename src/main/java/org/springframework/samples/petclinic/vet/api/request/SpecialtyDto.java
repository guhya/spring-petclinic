package org.springframework.samples.petclinic.vet.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Specialty")
public class SpecialtyDto {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("name")
	private String name;

}
