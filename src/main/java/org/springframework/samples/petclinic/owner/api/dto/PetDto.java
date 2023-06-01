package org.springframework.samples.petclinic.owner.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@JsonTypeName("Pet")
public class PetDto {

	@JsonProperty("name")
	@NotEmpty
	private String name;

	@JsonProperty("birthDate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotEmpty
	private LocalDate birthDate;

	@JsonProperty("type")
	@NotEmpty
	private PetTypeDto type;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("ownerId")
	@NotEmpty
	private Integer ownerId;

	@JsonProperty("visits")
	@Valid
	private List<VisitDto> visits = new ArrayList<>();

}
