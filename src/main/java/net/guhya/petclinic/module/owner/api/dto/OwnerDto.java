package net.guhya.petclinic.module.owner.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@JsonTypeName("Owner")
public class OwnerDto {

	@JsonProperty("firstName")
	@NotEmpty
	private String firstName;

	@JsonProperty("lastName")
	@NotEmpty
	private String lastName;

	@JsonProperty("address")
	@NotEmpty
	private String address;

	@JsonProperty("city")
	@NotEmpty
	private String city;

	@JsonProperty("telephone")
	@NotEmpty
	private String telephone;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("pets")
	@Valid
	private List<PetDto> pets = new ArrayList<>();

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<PetDto> getPets() {
		return pets;
	}

	public void setPets(List<PetDto> pets) {
		this.pets = pets;
	}
}
