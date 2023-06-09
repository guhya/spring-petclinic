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
package net.guhya.petclinic.module.vet.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import net.guhya.petclinic.module.vet.api.mapper.VetMapper;
import net.guhya.petclinic.module.vet.api.request.VetDto;
import net.guhya.petclinic.module.vet.data.Vet;
import net.guhya.petclinic.module.vet.projection.VetWithSpecialtiesDto;
import net.guhya.petclinic.module.vet.service.VetService;

@RestController
class VetRestController {

	private static final Logger logger = LoggerFactory.getLogger(VetRestController.class);
	
    private final VetService vetService;
    private final VetMapper vetMapper;
    
    public VetRestController(VetService vetService, VetMapper vetMapper) {
		this.vetService = vetService;
		this.vetMapper = vetMapper;
		
		logger.info("Vet API loaded");
	}
	
	@GetMapping("/vet")
    public ResponseEntity<List<VetWithSpecialtiesDto>> listVets(String lastName, 
    		@Min(1) Integer page, 
    		@Min(1) Integer pageSize) {
		List<VetWithSpecialtiesDto> vetListDto;
		Pageable pageable = PageRequest.of(0, 10000);
    	if (page != null && pageSize != null) {
    		page = page - 1;
    		pageable = PageRequest.of(page, pageSize);
    	}
		
        vetListDto = vetService.findAllVet(pageable);
        
        return new ResponseEntity<>(vetListDto, HttpStatus.OK);
    }
	
	@GetMapping("/vetWithSpecialties")
    public ResponseEntity<List<VetWithSpecialtiesDto>> listVetsWithSpecialties(String lastName, 
    		@Min(1) Integer page, 
    		@Min(1) Integer pageSize) {
		List<VetWithSpecialtiesDto> vetListDto;
		Pageable pageable = PageRequest.of(0, 10000);
    	if (page != null && pageSize != null) {
    		page = page - 1;
    		pageable = PageRequest.of(page, pageSize);
    	}
		
        vetListDto = vetService.findAllVet(pageable);
        
        return new ResponseEntity<>(vetListDto, HttpStatus.OK);
    }

	@GetMapping("/vet/{vetId}")
    public ResponseEntity<VetWithSpecialtiesDto> getVet(@PathVariable Integer vetId) {
		VetWithSpecialtiesDto vetWithSpecialtiesDto = vetService.findVetWithSpecialtiesByVetId(vetId);
        if (vetWithSpecialtiesDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
        
        return new ResponseEntity<>(vetWithSpecialtiesDto, HttpStatus.OK);
    }
	
	@PostMapping("/vet")
    public ResponseEntity<VetDto> addVet(@Valid @RequestBody VetDto vetDto) {
		if (vetDto.getVetId() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
        Vet vet = vetMapper.toVet(vetDto);
        vetService.save(vet);
        VetDto savedDto = vetMapper.toVetDto(vet);
        
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

	@DeleteMapping("/vet/{vetId}")
    public ResponseEntity<VetWithSpecialtiesDto> deleteVet(@PathVariable Integer vetId) {
		Vet existingVet = vetService.findByVetId(vetId);
		if (existingVet == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		vetService.delete(existingVet);
		
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
}
