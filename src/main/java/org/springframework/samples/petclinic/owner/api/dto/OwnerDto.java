package org.springframework.samples.petclinic.owner.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@JsonTypeName("Owner")
public class OwnerDto {

	@JsonProperty("firstName")
	@NotEmpty
	private String firstName;

	@JsonProperty("lastName")
	@NotEmpty
	private String lastName;

	@JsonProperty("address")
	@NotEmpty
	private String address;

	@JsonProperty("city")
	@NotEmpty
	private String city;

	@JsonProperty("telephone")
	@NotEmpty
	private String telephone;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("pets")
	@Valid
	private List<PetDto> pets = new ArrayList<>();
}
