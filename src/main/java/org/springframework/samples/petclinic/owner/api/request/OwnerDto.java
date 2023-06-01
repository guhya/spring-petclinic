package org.springframework.samples.petclinic.owner.api.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;

@JsonTypeName("Owner")
public class OwnerDto {

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("address")
	private String address;

	@JsonProperty("city")
	private String city;

	@JsonProperty("telephone")
	private String telephone;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("pets")
	@Valid
	private List<PetDto> pets = new ArrayList<>();
}
