/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.guhya.petclinic.module.vet.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "vet")
public class Vet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vet_id")
	private Integer vetId;
	
	@Column(name = "first_name")
	@NotEmpty
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty
	private String lastName;

	@OneToMany(mappedBy = "vet", fetch = FetchType.LAZY)
	private List<VetSpecialty> vetSpecialties;

	public Integer getVetId() {
		return vetId;
	}

	public void setTypeId(Integer vetId) {
		this.vetId = vetId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected List<VetSpecialty> getVetSpecialtiesInternal() {
		if (this.vetSpecialties == null) {
			this.vetSpecialties = new ArrayList<>();
		}
		return this.vetSpecialties;
	}

	protected void setSpecialtiesInternal(List<VetSpecialty> vetSpecialties) {
		this.vetSpecialties = vetSpecialties;
	}

	@XmlElement
	public List<VetSpecialty> getSpecialties() {
		return Collections.unmodifiableList(getVetSpecialtiesInternal());
	}

	public int getNrOfVetSpecialties() {
		return getVetSpecialtiesInternal().size();
	}

	public void addVetSpecialty(VetSpecialty vetSpecialty) {
		getVetSpecialtiesInternal().add(vetSpecialty);
	}

}
