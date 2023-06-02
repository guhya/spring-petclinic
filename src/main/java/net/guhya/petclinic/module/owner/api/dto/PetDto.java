package net.guhya.petclinic.module.owner.api.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

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
	private String type;

	@JsonProperty("petId")
	private Integer petId;

	@JsonProperty("ownerId")
	@NotEmpty
	private Integer ownerId;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}	
	
}
