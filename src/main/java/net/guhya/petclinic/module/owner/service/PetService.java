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
package net.guhya.petclinic.module.owner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.guhya.petclinic.module.owner.api.dto.PetWithTypeAndOwnerDto;
import net.guhya.petclinic.module.owner.data.Pet;
import net.guhya.petclinic.module.owner.repository.PetRepository;

@Service
public class PetService {

    private PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

	@Transactional(readOnly = true)
	public List<PetWithTypeAndOwnerDto> findAllWithTypeAndOwner() throws DataAccessException {
		return petRepository.findAllWithTypeAndOwner();
	}

	@Transactional(readOnly = true)
	public PetWithTypeAndOwnerDto findWithTypeAndOwnerByPetId(int ownerId, int petId) throws DataAccessException {
		PetWithTypeAndOwnerDto pet = petRepository.findWithTypeAndOwnerByPetId(ownerId, petId);
		return pet;
	}

	@Transactional(readOnly = true)
	public List<PetWithTypeAndOwnerDto> findAllWithTypeAndOwnerByOwnerId(int ownerId) throws DataAccessException {
		return petRepository.findAllWithTypeAndOwnerByOwnerId(ownerId);
	}

	@Transactional(readOnly = true)
	public Pet findByPetId(int petId) throws DataAccessException {
		Pet pet = petRepository.findByPetId(petId);
		return pet;
	}

	@Transactional
	public void save(Pet pet) throws DataAccessException {
		petRepository.save(pet);
	}

	@Transactional
	public void delete(Pet pet) throws DataAccessException {
		petRepository.delete(pet);
	}

}
