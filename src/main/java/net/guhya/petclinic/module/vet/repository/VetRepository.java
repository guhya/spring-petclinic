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
package net.guhya.petclinic.module.vet.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import net.guhya.petclinic.module.vet.data.Specialty;
import net.guhya.petclinic.module.vet.data.Vet;
import net.guhya.petclinic.module.vet.data.VetSpecialty;
import net.guhya.petclinic.module.vet.projection.VetSpecialtyWithNameDto;
import net.guhya.petclinic.module.vet.projection.VetWithSpecialtiesDto;

public interface VetRepository extends Repository<Vet, Integer> {

	final String JPQL_QUERY = ""
			  + "SELECT new net.guhya.petclinic.module.vet.projection.VetWithSpecialtiesDto("
			  + "	a.vetId, a.firstName, a.lastName"
			  + ") "
			  + "FROM Vet a ";
	
	final String ORDER_BY = "ORDER BY a.vetId DESC";
	
    @Query(nativeQuery = false, 
    		value = "SELECT a.vetId FROM Vet a " + ORDER_BY)
    List<Integer> findAllVetId(Pageable pageable) throws DataAccessException;
    
    @Query(nativeQuery = false, 
    		value = JPQL_QUERY
    			  + "WHERE a.vetId IN :vetIdList "
    			  + ORDER_BY)
    List<VetWithSpecialtiesDto> findAllVet(List<Integer> vetIdList) throws DataAccessException;

    @Query(nativeQuery = false, 
    		value = JPQL_QUERY
    			  + "WHERE a.vetId = :vetId")
    VetWithSpecialtiesDto findVetWithSpecialtiesByVetId(int vetId) throws DataAccessException;
    
    @Query(nativeQuery = false, 
    		value = ""
				  + "SELECT new net.guhya.petclinic.module.vet.projection.VetSpecialtyWithNameDto("
				  + "	a.vetSpecialtyKey.vetId AS vetId, a.vetSpecialtyKey.specialtyId AS specialtyId, b.name AS specialtyName"
				  + ") "
				  + "FROM VetSpecialty a "
				  + "	LEFT JOIN a.specialty b "
    			  + "WHERE a.vetSpecialtyKey.vetId IN :vetIdList "
    			  + "ORDER BY a.vetSpecialtyKey.vetId ASC, a.vetSpecialtyKey.specialtyId ASC")
    List<VetSpecialtyWithNameDto> findAllVetSpecialty(List<Integer> vetIdList) throws DataAccessException;
    
    Vet findByVetId(int vetId) throws DataAccessException;

    @Query(nativeQuery = false, 
    		value = "SELECT a FROM Specialty a "
    			  + "WHERE a.specialtyId = :specialtyId")
    Specialty findSpecialtyBySpecialtyId(int specialtyId) throws DataAccessException;

    void save(Vet vet) throws DataAccessException;

	void saveAndFlush(Vet vet) throws DataAccessException;;
    
	void save(VetSpecialty vetSpecialty) throws DataAccessException;

    void delete(Vet vet) throws DataAccessException;

}
