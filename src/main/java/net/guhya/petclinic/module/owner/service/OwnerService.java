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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.guhya.petclinic.module.owner.data.Owner;
import net.guhya.petclinic.module.owner.repository.OwnerRepository;

@Service
public class OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

	@Transactional(readOnly = true)
	public List<Owner> findAll() throws DataAccessException {
		return ownerRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Owner> findAllOwnersAndTheirPets() throws DataAccessException {
		return ownerRepository.findAllOwnersAndTheirPets();
	}

	@Transactional
	public void delete(Owner owner) throws DataAccessException {
		ownerRepository.delete(owner);
	}

	@Transactional(readOnly = true)
	public Owner findByOwnerId(int id) throws DataAccessException {
		Owner owner = null;
		try {
			owner = ownerRepository.findByOwnerId(id);
		} catch (ObjectRetrievalFailureException|EmptyResultDataAccessException e) {
			// just ignore not found exceptions for Jdbc/Jpa realization
			return null;
		}
		return owner;
	}

	@Transactional
	public void save(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}

	@Transactional(readOnly = true)
	public List<Owner> findByLastName(String lastName) throws DataAccessException {
		return ownerRepository.findByLastName(lastName);
	}

}
