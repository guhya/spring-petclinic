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

import net.guhya.petclinic.module.owner.api.dto.VisitWithPetDto;
import net.guhya.petclinic.module.owner.data.Pet;
import net.guhya.petclinic.module.owner.data.Visit;

public interface VisitRepository extends Repository<Visit, Integer>{

	final String QUERY = ""
			  + "SELECT new net.guhya.petclinic.module.owner.api.dto.VisitWithPetDto("
			  + "	a.visitId AS visitId, b.petId AS petId, b.name AS petName "
			  + "	, a.date AS date, a.description AS description"
			  + ") "
			  + "FROM Visit a "
			  + "	LEFT JOIN a.pet b ";
	
	final String ORDER_BY = "ORDER BY a.date DESC";

    @Query(nativeQuery = false,
    		value = QUERY
    			  + "WHERE b.petId = :petId "
    			  + ORDER_BY)
    List<VisitWithPetDto> findAllByPetId(Integer petId);

    Visit findByVisitId(int visitId) throws DataAccessException;

    Visit findByPetPetIdAndVisitId(int petId, int visitId) throws DataAccessException;

    void delete(Visit visit) throws DataAccessException;

	void save(Visit visit) throws DataAccessException;
}
