/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.guhya.petclinic.module.owner.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import net.guhya.petclinic.module.common.entity.NamedEntity;

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Column(name = "birth_date", columnDefinition = "DATE")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    @OrderBy("date DESC")
    private List<Visit> visits;

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return this.type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    protected List<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new ArrayList<>();
        }
        return this.visits;
    }

    protected void setVisitsInternal(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Visit> getVisits() {
        return Collections.unmodifiableList(getVisitsInternal());
    }

    public void setVisits(List<Visit> visits) {
        this.visits = new ArrayList<>(visits);
    }

    public void addVisit(Visit visit) {
        getVisitsInternal().add(visit);
        visit.setPet(this);
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pet [birthDate=");
		builder.append(birthDate);
		builder.append(", type=");
		builder.append(type);
		builder.append(", owner=");
		builder.append(owner.getId());
		builder.append(", visits=");
		builder.append(visits);
		builder.append("]");
		return builder.toString();
	}
    
    

}
