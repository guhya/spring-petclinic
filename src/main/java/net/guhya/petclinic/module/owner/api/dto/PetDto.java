package net.guhya.petclinic.module.owner.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	private Integer ownerId;

	@JsonProperty("visits")
	@Valid
	private List<VisitDto> visits = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public PetTypeDto getType() {
		return type;
	}

	public void setType(PetTypeDto type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public List<VisitDto> getVisits() {
		return visits;
	}

	public void setVisits(List<VisitDto> visits) {
		this.visits = visits;
	}
	
	
}
