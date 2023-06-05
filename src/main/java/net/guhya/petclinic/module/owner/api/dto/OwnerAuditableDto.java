package net.guhya.petclinic.module.owner.api.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import net.guhya.petclinic.module.common.api.SimpleAuditDto;

@JsonTypeName("OwnerAuditable")
@JsonPropertyOrder({ "ownerId", "firstName", "lastName", "address", "city", "telephone", "createdBy", "createdAt", "modifiedBy", "modifiedAt" })
public class OwnerAuditableDto extends SimpleAuditDto {

	private Integer ownerId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String telephone;
		
	public OwnerAuditableDto(String firstName,  String lastName,  String address,  String city, String telephone, Integer ownerId, 
			String createdBy, LocalDateTime createdAt, String modifiedBy, LocalDateTime modifiedAt) {
		super(createdBy, createdAt, modifiedBy, modifiedAt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
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
