package net.guhya.petclinic.module.vet.projection;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Vet")
public class VetWithSpecialtiesDto {

	private Integer vetId;
	private String firstName;
	private String lastName;
	private List<VetSpecialtyWithNameDto> specialties = new ArrayList<>();
	
	public VetWithSpecialtiesDto(Integer vetId, String firstName, String lastName) {
		super();
		this.vetId = vetId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
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
	public List<VetSpecialtyWithNameDto> getSpecialties() {
		return specialties;
	}
	public void setSpecialties(List<VetSpecialtyWithNameDto> specialties) {
		this.specialties = specialties;
	}
	
	
}
