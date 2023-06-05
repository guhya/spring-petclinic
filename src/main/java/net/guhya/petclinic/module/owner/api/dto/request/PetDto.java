package net.guhya.petclinic.module.owner.api.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@JsonTypeName("Pet")
public class PetDto {

	@NotEmpty
	private String name;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@NotNull
	private LocalDate birthDate;

	@Range(min=1, max=6)
	private Integer typeId;

	private Integer petId;

	@Range(min=1)
	private Integer ownerId;

	public PetDto() {}
	
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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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
