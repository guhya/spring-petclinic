package org.springframework.samples.petclinic.vet.api.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;

@JsonTypeName("Vet")
public class VetDto {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("specialties")
	@Valid
	private List<SpecialtyDto> specialties = new ArrayList<>();

	@JsonProperty("id")
	private Integer id;

}
