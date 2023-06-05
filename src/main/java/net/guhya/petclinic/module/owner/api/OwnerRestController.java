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
package net.guhya.petclinic.module.owner.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.guhya.petclinic.module.owner.api.dto.OwnerAuditableDto;
import net.guhya.petclinic.module.owner.api.dto.OwnerAuditableWithPetsDto;
import net.guhya.petclinic.module.owner.api.dto.PetWithTypeAndOwnerDto;
import net.guhya.petclinic.module.owner.api.dto.request.OwnerDto;
import net.guhya.petclinic.module.owner.api.dto.request.PetDto;
import net.guhya.petclinic.module.owner.api.mapper.OwnerMapper;
import net.guhya.petclinic.module.owner.api.mapper.PetMapper;
import net.guhya.petclinic.module.owner.data.Owner;
import net.guhya.petclinic.module.owner.data.Pet;
import net.guhya.petclinic.module.owner.service.OwnerService;
import net.guhya.petclinic.module.owner.service.PetService;

@RestController
class OwnerRestController {

	private static final Logger logger = LoggerFactory.getLogger(OwnerRestController.class);
	
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    private final PetService petService;
    private final PetMapper petMapper;
    
    public OwnerRestController(OwnerService ownerService, OwnerMapper ownerMapper
    		, PetService petService, PetMapper petMapper) {
		this.ownerService = ownerService;
		this.ownerMapper = ownerMapper;
		this.petService = petService;
		this.petMapper = petMapper;
		
		logger.info("Owner API loaded");
	}
	
	@GetMapping("/owner")
    public ResponseEntity<List<OwnerAuditableDto>> listOwners(String lastName) {
		List<OwnerAuditableDto> ownerListDto;
        if (lastName != null) {
        	ownerListDto = ownerService.findOwnerAuditableByLastName(lastName);
        } else {
        	ownerListDto = ownerService.findOwnerAuditableAll();
        }
        
        return new ResponseEntity<>(ownerListDto, HttpStatus.OK);
    }
	
	@GetMapping("/owner/{ownerId}")
    public ResponseEntity<OwnerAuditableDto> getOwner(@PathVariable Integer ownerId) {
		OwnerAuditableDto ownerAuditableDto = ownerService.findOwnerAuditableByOwnerId(ownerId);
        if (ownerAuditableDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
        
        return new ResponseEntity<>(ownerAuditableDto, HttpStatus.OK);
    }
	
	@GetMapping("/ownerWithPets/{ownerId}")
    public ResponseEntity<OwnerAuditableWithPetsDto> getOwnerWithPets(@PathVariable Integer ownerId) {
		OwnerAuditableWithPetsDto ownerAuditableDto = ownerService.findOwnerAuditableWithPetsByOwnerId(ownerId);
        if (ownerAuditableDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);    
        
        ownerAuditableDto.setPets(petService.findAllWithTypeAndOwnerByOwnerId(ownerId));
        
        return new ResponseEntity<>(ownerAuditableDto, HttpStatus.OK);
    }

	@PostMapping("/owner")
    public ResponseEntity<OwnerDto> addOwner(@Valid @RequestBody OwnerDto ownerDto) {
		if (ownerDto.getOwnerId() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
        Owner owner = ownerMapper.toOwner(ownerDto);
        ownerService.save(owner);
        OwnerDto savedDto = ownerMapper.toOwnerDto(owner);
        
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

	@PutMapping("/owner")
    public ResponseEntity<OwnerDto> updateOwner(@Valid @RequestBody OwnerDto ownerDto) {
		if (ownerDto.getOwnerId() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		OwnerAuditableDto existingOwnerAuditableDto = ownerService.findOwnerAuditableByOwnerId(ownerDto.getOwnerId());
		if (existingOwnerAuditableDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
        Owner owner = ownerMapper.toOwner(ownerDto);
        ownerService.save(owner);
        OwnerDto savedDto = ownerMapper.toOwnerDto(owner);
        
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }
	
	@DeleteMapping("/owner/{ownerId}")
    public ResponseEntity<OwnerDto> deleteOwner(@PathVariable Integer ownerId) {
		Owner existingOwner = ownerService.findByOwnerId(ownerId);
		if (existingOwner == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		ownerService.delete(existingOwner);
		
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	@GetMapping("/owner/{ownerId}/pet")
    public ResponseEntity<List<PetWithTypeAndOwnerDto>> listOwnerPets(@PathVariable Integer ownerId) {
		List<PetWithTypeAndOwnerDto> petListDto = petService.findAllWithTypeAndOwnerByOwnerId(ownerId);
		
        return new ResponseEntity<>(petListDto, HttpStatus.OK);
    }
	
	@GetMapping("/owner/{ownerId}/pet/{petId}")
    public ResponseEntity<PetWithTypeAndOwnerDto> getOwnerPet(@PathVariable Integer petId) {
		PetWithTypeAndOwnerDto petDto = petService.findWithTypeAndOwnerByPetId(petId);
        if (petDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
        
        return new ResponseEntity<>(petDto, HttpStatus.OK);
    }
	
	@PostMapping("/owner/{ownerId}/pet")
    public ResponseEntity<PetDto> addOwnerPet(@Valid @RequestBody PetDto petDto) {
		if (petDto.getPetId() != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
        Pet pet = petMapper.toPet(petDto);
        petService.save(pet);
        PetDto savedDto = petMapper.toPetDto(pet);
        
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

	@PutMapping("/owner/{ownerId}/pet")
    public ResponseEntity<PetDto> updateOwnerPet(@Valid @RequestBody PetDto petDto) {
		if (petDto.getPetId() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Pet existingPet = petService.findByPetId(petDto.getPetId());
		if (existingPet == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
        Pet pet = petMapper.toPet(petDto);
        petService.save(pet);
        PetDto savedDto = petMapper.toPetDto(pet);        
        
        return new ResponseEntity<>(savedDto, HttpStatus.OK);
    }
	
	@DeleteMapping("/owner/{ownerId}/pet/{petId}")
    public ResponseEntity<PetDto> deleteOwnerPet(@PathVariable Integer petId) {
		Pet existingPet = petService.findByPetId(petId);
		if (existingPet == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		petService.delete(existingPet);
		
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
}
