package org.springframework.samples.petclinic.owner.api.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Visit")
public class VisitDto {

	@JsonProperty("date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("petId")
	private Integer petId;

}
