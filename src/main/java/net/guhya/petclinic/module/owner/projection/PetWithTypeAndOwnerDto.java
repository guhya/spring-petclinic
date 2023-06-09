package net.guhya.petclinic.module.owner.projection;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("PetWithTypeAndOwner")
@JsonPropertyOrder({ "petId", "name", "birthDate", "typeName", "ownerName" })
public class PetWithTypeAndOwnerDto {

	private Integer petId;
	private String name;
	private LocalDate birthDate;
	private String typeName;
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
