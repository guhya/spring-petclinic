/*
 * Copyright 2002-2017 the original author or authors.
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
package net.guhya.petclinic.module.vet.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.guhya.petclinic.module.vet.api.request.VetSpecialtyDto;
import net.guhya.petclinic.module.vet.data.Specialty;
import net.guhya.petclinic.module.vet.data.Vet;
import net.guhya.petclinic.module.vet.data.VetSpecialty;
import net.guhya.petclinic.module.vet.projection.VetSpecialtyWithNameDto;
import net.guhya.petclinic.module.vet.projection.VetWithSpecialtiesDto;
import net.guhya.petclinic.module.vet.repository.VetRepository;

@Service
public class VetService {

    private VetRepository vetRepository;

    @Autowired
    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

	@Transactional(readOnly = true)
	public List<VetWithSpecialtiesDto> findAllVet(Pageable pageable) throws DataAccessException {
		List<Integer> vetIdList = vetRepository.findAllVetId(pageable);
		List<VetWithSpecialtiesDto> vetList = vetRepository.findAllVet(vetIdList);
		List<VetSpecialtyWithNameDto> vetSpecialtyList = vetRepository.findAllVetSpecialty(vetIdList);
		
		for (VetWithSpecialtiesDto vet : vetList) {
			Integer vetId = vet.getVetId();
			for (VetSpecialtyWithNameDto vetSpecialty : vetSpecialtyList) {
				if (vetSpecialty.getVetId().equals(vetId)) {
					vet.getSpecialties().add(vetSpecialty);
				}
			}
		}
		
		return vetList;
	}

	@Transactional(readOnly = true)
	public VetWithSpecialtiesDto findVetWithSpecialtiesByVetId(int vetId) throws DataAccessException {
		VetWithSpecialtiesDto vetWithSpecialtiesDto = vetRepository.findVetWithSpecialtiesByVetId(vetId);
		List<VetSpecialtyWithNameDto> vetSpecialtyList = vetRepository.findAllVetSpecialty(Arrays.asList(new Integer[] {vetId}));
		vetWithSpecialtiesDto.setSpecialties(vetSpecialtyList);
		
		return vetWithSpecialtiesDto;
	}

	@Transactional(readOnly = true)
	public Vet findByVetId(int vetId) throws DataAccessException {
		return vetRepository.findByVetId(vetId);
	}
	
	@Transactional(readOnly = true)
	public Specialty findSpecialtyBySpecialtyId(int specialtyId) throws DataAccessException {
		return vetRepository.findSpecialtyBySpecialtyId(specialtyId);
	}

	@Transactional
	public void save(Vet vet) throws DataAccessException {
    	vetRepository.save(vet);
	}

	@Transactional
	public void save(Vet vet, List<VetSpecialtyDto> specialties) throws DataAccessException {
		vetRepository.saveAndFlush(vet);
        
		for (VetSpecialtyDto vetSpecialtyDto : specialties) {
        	Specialty specialty = vetRepository.findSpecialtyBySpecialtyId(vetSpecialtyDto.getSpecialtyId());
        	
        	VetSpecialty vetSpecialty = new VetSpecialty(vet.getVetId(), specialty.getSpecialtyId());
        	vetSpecialty.setSpecialty(specialty);
        	vetSpecialty.setVet(vet);
        	vet.getSpecialties().add(vetSpecialty);
        	specialty.getSpecialties().add(vetSpecialty);
        	vetRepository.save(vetSpecialty);
        }
	}

	@Transactional
	public void save(VetSpecialty vetSpecialty) throws DataAccessException {
		vetRepository.save(vetSpecialty);
	}

	@Transactional
	public void delete(Vet vet) throws DataAccessException {
		vetRepository.delete(vet);
	}
	
}
