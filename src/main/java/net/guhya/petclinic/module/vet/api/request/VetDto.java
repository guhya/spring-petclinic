package net.guhya.petclinic.module.vet.api.request;

import jakarta.validation.constraints.NotEmpty;

public class VetDto {

	private Integer vetId;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;
	
	

	public Integer getVetId() {
		return vetId;
	}

	public void setVetId(Integer vetId) {
		this.vetId = vetId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
