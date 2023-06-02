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

import net.guhya.petclinic.module.owner.data.Owner;

public interface OwnerRepository extends Repository<Owner, Integer> {

    @Query(nativeQuery = true,
    		value = "SELECT * FROM owner WHERE last_name LIKE %:lastName% ORDER BY owner_id DESC")
	List<Owner> findByLastName(String lastName) throws DataAccessException;

    @Query(nativeQuery = true,
    		value = "SELECT * FROM owner WHERE owner_id = :id ORDER BY owner_id DESC")
    Owner findByOwnerId(int id) throws DataAccessException;

    @Query(nativeQuery = true,
    		value = "SELECT * FROM owner ORDER BY owner_id DESC")
    List<Owner> findAll() throws DataAccessException;
	
    @Query("SELECT owner FROM Owner owner LEFT JOIN FETCH owner.pets")
    List<Owner> findAllOwnersAndTheirPets() throws DataAccessException;

    void save(Owner owner) throws DataAccessException;
    
	void delete(Owner owner) throws DataAccessException;
}
