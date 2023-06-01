package org.springframework.samples.petclinic.owner.api.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotEmpty;

@JsonTypeName("Visit")
public class VisitDto {

	@JsonProperty("date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotEmpty
	private LocalDate date;

	@JsonProperty("description")
	@NotEmpty
	private String description;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("petId")
	@NotEmpty
	private Integer petId;

}
