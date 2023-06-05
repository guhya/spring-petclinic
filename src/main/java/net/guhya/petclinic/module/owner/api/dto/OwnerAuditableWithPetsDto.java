package net.guhya.petclinic.module.owner.api.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("OwnerAuditableWithPets")
public class OwnerAuditableWithPetsDto extends OwnerAuditableDto {
	
	public OwnerAuditableWithPetsDto(String firstName, String lastName, String address, String city, String telephone,
			Integer ownerId, String createdBy, LocalDateTime createdAt, String modifiedBy, LocalDateTime modifiedAt) {
		super(firstName, lastName, address, city, telephone, ownerId, createdBy, createdAt, modifiedBy, modifiedAt);
	}

	private List<PetWithTypeAndOwnerDto> pets;
		
	public List<PetWithTypeAndOwnerDto> getPets() {
		return pets;
	}

	public void setPets(List<PetWithTypeAndOwnerDto> pets) {
		this.pets = pets;
	}

}
