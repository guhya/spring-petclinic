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

import net.guhya.petclinic.module.owner.api.dto.VisitWithPetDto;
import net.guhya.petclinic.module.owner.data.Visit;
import net.guhya.petclinic.module.owner.repository.VisitRepository;

@Service
public class VisitService {

    private VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

	@Transactional(readOnly = true)
	public List<VisitWithPetDto> findAllByPetId(Integer petId) throws DataAccessException {
		return visitRepository.findAllByPetId(petId);
	}

	@Transactional(readOnly = true)
	public Visit findByVisitId(int visitId) throws DataAccessException {
		Visit visit = visitRepository.findByVisitId(visitId);
		return visit;
	}

	@Transactional(readOnly = true)
	public Visit findByPetIdAndVisitId(int petId, int visitId) throws DataAccessException {
		Visit visit = visitRepository.findByPetPetIdAndVisitId(petId, visitId);
		return visit;
	}

	@Transactional
	public void save(Visit visit) throws DataAccessException {
		visitRepository.save(visit);
	}
	
	@Transactional
	public void delete(Visit visit) throws DataAccessException {
		visitRepository.delete(visit);
	}
}
