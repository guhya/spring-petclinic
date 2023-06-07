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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.guhya.petclinic.module.owner.api.dto.OwnerAuditableDto;
import net.guhya.petclinic.module.owner.api.dto.OwnerAuditableWithPetsDto;
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
	public List<OwnerAuditableDto> findAllOwnerAuditable(Pageable pageable) throws DataAccessException {
		return ownerRepository.findAllOwnerAuditable(pageable);
	}

	@Transactional(readOnly = true)
	public List<OwnerAuditableDto> findOwnerAuditableByLastName(String lastName, Pageable pageable) throws DataAccessException {
		return ownerRepository.findOwnerAuditableByLastName(lastName, pageable);
	}

	@Transactional(readOnly = true)
	public OwnerAuditableDto findOwnerAuditableByOwnerId(int ownerId) throws DataAccessException {
		OwnerAuditableDto owner = ownerRepository.findOwnerAuditableByOwnerId(ownerId);
		return owner;
	}

	@Transactional(readOnly = true)
	public OwnerAuditableWithPetsDto findOwnerAuditableWithPetsByOwnerId(int ownerId) throws DataAccessException {
		OwnerAuditableWithPetsDto owner = ownerRepository.findOwnerAuditableWithPetsByOwnerId(ownerId);
		return owner;
	}

	@Transactional(readOnly = true)
	public Owner findByOwnerId(int ownerId) throws DataAccessException {
		Owner owner = ownerRepository.findByOwnerId(ownerId);
		return owner;
	}
	
	@Transactional
	public void save(Owner owner) throws DataAccessException {
		ownerRepository.save(owner);
	}

	@Transactional
	public void delete(Owner owner) throws DataAccessException {
		ownerRepository.delete(owner);
	}

}
