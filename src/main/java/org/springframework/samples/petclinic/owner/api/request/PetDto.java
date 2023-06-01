package org.springframework.samples.petclinic.owner.api.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;

@JsonTypeName("Pet")
public class PetDto {

	@JsonProperty("name")
	private String name;

	@JsonProperty("birthDate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate birthDate;

	@JsonProperty("type")
	private PetTypeDto type;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("ownerId")
	private Integer ownerId;

	@JsonProperty("visits")
	@Valid
	private List<VisitDto> visits = new ArrayList<>();

}
