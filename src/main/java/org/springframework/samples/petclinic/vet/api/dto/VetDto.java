package org.springframework.samples.petclinic.vet.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@JsonTypeName("Vet")
public class VetDto {

	@JsonProperty("firstName")
	@NotEmpty
	private String firstName;

	@JsonProperty("lastName")
	@NotEmpty
	private String lastName;

	@JsonProperty("specialties")
	@Valid
	private List<SpecialtyDto> specialties = new ArrayList<>();

	@JsonProperty("id")
	private Integer id;

}
