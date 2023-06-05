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
import org.springframework.data.repository.Repository;

import net.guhya.petclinic.module.owner.data.Visit;

public interface VisitRepository extends Repository<Visit, Integer>{

	final String QUERY = ""
			  + "SELECT new net.guhya.petclinic.module.owner.api.dto.PetWithTypeAndOwnerDto("
			  + "	a.petId AS petId, a.name AS name, a.birthDate AS birthDate"
			  + "	, c.name AS typeName, CONCAT(COALESCE(b.firstName,''), ' ', COALESCE(b.lastName,'')) AS ownerName"
			  + ") "
			  + "FROM Pet a "
			  + "	LEFT JOIN a.owner b "
			  + "	LEFT JOIN a.type c ";

	void save(Visit visit) throws DataAccessException;

    List<Visit> findByPetPetId(Integer petId);
    
	Visit findByVisitId(Integer visitId) throws DataAccessException;
	
	List<Visit> findAll() throws DataAccessException;

	void delete(Visit visit) throws DataAccessException;

}
