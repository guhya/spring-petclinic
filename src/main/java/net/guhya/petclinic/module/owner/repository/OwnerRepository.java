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

import net.guhya.petclinic.module.owner.api.dto.OwnerAuditableDto;
import net.guhya.petclinic.module.owner.data.Owner;

public interface OwnerRepository extends Repository<Owner, Integer> {
	
	final String OWNER_DTO_QUERY = ""
			  + "SELECT new net.guhya.petclinic.module.owner.api.dto.OwnerAuditableDto("
			  + "	a.firstName, a.lastName, a.address, a.city, a.telephone, a.ownerId"
			  + "	, a.createdBy, a.createdAt, a.modifiedBy, a.modifiedAt "
			  + ") "
			  + "FROM Owner a ";
	
	final String ORDER_BY_ID = "ORDER BY a.ownerId DESC";

    @Query(nativeQuery = false,
    		value = OWNER_DTO_QUERY
    			  + "WHERE a.lastName LIKE %:lastName% "
    			  + ORDER_BY_ID)
	List<OwnerAuditableDto> findOwnerAuditableByLastName(String lastName) throws DataAccessException;

    @Query(nativeQuery = false,
    		value = OWNER_DTO_QUERY
    			  + "WHERE a.ownerId = :id ")
    OwnerAuditableDto findOwnerAuditableByOwnerId(int id) throws DataAccessException;

    @Query(nativeQuery = false,
    		value = OWNER_DTO_QUERY
    			  + ORDER_BY_ID)
    List<OwnerAuditableDto> findAllOwnerAuditable() throws DataAccessException;
	
    Owner findByOwnerId(int ownerId) throws DataAccessException;

    void save(Owner owner) throws DataAccessException;
    
	void delete(Owner owner) throws DataAccessException;
}
