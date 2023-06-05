package net.guhya.petclinic.module.owner.api.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotEmpty;

@JsonTypeName("Pet")
@JsonPropertyOrder({ "petId", "name", "birthDate", "typeName", "ownerName" })
public class PetWithTypeAndOwnerDto {

	@JsonProperty("petId")
	private Integer petId;

	@JsonProperty("name")
	@NotEmpty
	private String name;

	@JsonProperty("birthDate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotEmpty
	private LocalDate birthDate;

	@JsonProperty("typeName")
	@NotEmpty
	private String typeName;

	@JsonProperty("ownerName")
	private String ownerName;

	public PetWithTypeAndOwnerDto() {}
	
	public PetWithTypeAndOwnerDto(String name, LocalDate birthDate, String typeName, Integer petId, String ownerName) {
		this.name = name;
		this.birthDate = birthDate;
		this.typeName = typeName;
		this.petId = petId;
		this.ownerName = ownerName;
	}
	
	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}	
	
}
