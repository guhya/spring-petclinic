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
package net.guhya.petclinic.module.owner.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import net.guhya.petclinic.module.owner.api.dto.PetWithTypeAndOwnerDto;
import net.guhya.petclinic.module.owner.data.Pet;

public interface PetRepository extends Repository<Pet, Integer> {

	final String QUERY = ""
			  + "SELECT new net.guhya.petclinic.module.owner.api.dto.PetWithTypeAndOwnerDto("
			  + "	a.petId AS petId, a.name AS name, a.birthDate AS birthDate"
			  + "	, c.name AS typeName, CONCAT(COALESCE(b.firstName,''), ' ', COALESCE(b.lastName,'')) AS ownerName"
			  + ") "
			  + "FROM Pet a "
			  + "	LEFT JOIN a.owner b "
			  + "	LEFT JOIN a.type c ";
	
	final String ORDER_BY_ID = "ORDER BY a.petId DESC";
	
    @Query(nativeQuery = false,
    		value = QUERY
    			  + "WHERE a.petId = :petId")
    PetWithTypeAndOwnerDto findWithTypeAndOwnerByPetId(int petId) throws DataAccessException;
    
    @Query(nativeQuery = false,
    		value = QUERY
    			  + ORDER_BY_ID)
    List<PetWithTypeAndOwnerDto> findAllWithTypeAndOwner() throws DataAccessException;

    @Query(nativeQuery = false,
    		value = QUERY
    			  + "WHERE b.ownerId = :ownerId "
    			  + ORDER_BY_ID)
    List<PetWithTypeAndOwnerDto> findAllWithTypeAndOwnerByOwnerId(int ownerId) throws DataAccessException;

    Pet findByPetId(int petId) throws DataAccessException;

    void save(Pet pet) throws DataAccessException;

	void delete(Pet pet) throws DataAccessException;

}
