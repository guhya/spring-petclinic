package net.guhya.petclinic.module.owner.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import net.guhya.petclinic.module.owner.api.dto.request.PetDto;

@JsonTypeName("OwnerAndPet")
@JsonPropertyOrder({ "ownerId", "firstName", "lastName", "address", "city", "telephone" })
public class OwnerAndPetDto {

	private Integer ownerId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String telephone;
	private List<PetDto> pets = new ArrayList<>();

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public List<PetDto> getPets() {
		return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}	

}
