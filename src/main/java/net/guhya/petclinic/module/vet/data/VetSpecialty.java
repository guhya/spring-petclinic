package net.guhya.petclinic.module.vet.data;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "vet_specialty")
public class VetSpecialty {
	
	@EmbeddedId
	private VetSpecialtyKey vetSpecialtyKey;
	
	@ManyToOne
	@MapsId("vetId")
	@JoinColumn(name = "vet_id")
	Vet vet;
	
	@ManyToOne
	@MapsId("specialtyId")
	@JoinColumn(name = "specialty_id")
	Specialty specialty;

	public VetSpecialty() {};
	
	public VetSpecialty(Integer vetId, Integer specialtyId) {
		VetSpecialtyKey key = new VetSpecialtyKey();
		key.setVetId(vetId);
		key.setSpecialtyId(specialtyId);
		
		this.vetSpecialtyKey = key;
	}

	public VetSpecialtyKey getVetSpecialtyKey() {
		return vetSpecialtyKey;
	}

	public void setVetSpecialtyKey(VetSpecialtyKey vetSpecialtyKey) {
		this.vetSpecialtyKey = vetSpecialtyKey;
	}

	public Vet getVet() {
		return vet;
	}

	public void setVet(Vet vet) {
		this.vet = vet;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
		
}
