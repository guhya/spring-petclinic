package net.guhya.petclinic.module.owner.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

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

	@JsonProperty("ownerId")
	private Integer ownerId;

	public OwnerDto() {}
	
	public OwnerDto(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String address,
			@NotEmpty String city, @NotEmpty String telephone, Integer ownerId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
		this.ownerId = ownerId;
	}

	public OwnerDto(@NotEmpty String firstName, @NotEmpty String lastName, Integer ownerId) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

}
