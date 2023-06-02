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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlElement;

/**
 * Simple JavaBean domain object representing a veterinarian.
 */
@Entity
@Table(name = "vet")
public class Vet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vet_id")
	private Integer vetId;

	public Integer getVetId() {
		return vetId;
	}

	public void setTypeId(Integer vetId) {
		this.vetId = vetId;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialty", joinColumns = @JoinColumn(name = "vet_id"),
			inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private List<Specialty> specialties;

	protected List<Specialty> getSpecialtiesInternal() {
		if (this.specialties == null) {
			this.specialties = new ArrayList<>();
		}
		return this.specialties;
	}

	protected void setSpecialtiesInternal(List<Specialty> specialties) {
		this.specialties = specialties;
	}

	@XmlElement
	public List<Specialty> getSpecialties() {
		return Collections.unmodifiableList(getSpecialtiesInternal());
	}

	public int getNrOfSpecialties() {
		return getSpecialtiesInternal().size();
	}

	public void addSpecialty(Specialty specialty) {
		getSpecialtiesInternal().add(specialty);
	}

}
