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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.guhya.petclinic.module.owner.api.dto.OwnerDto;
import net.guhya.petclinic.module.owner.api.mapper.OwnerMapper;
import net.guhya.petclinic.module.owner.api.mapper.PetMapper;
import net.guhya.petclinic.module.owner.api.mapper.VisitMapper;
import net.guhya.petclinic.module.owner.data.Owner;
import net.guhya.petclinic.module.owner.service.OwnerService;

@RestController
class OwnerRestController {

	private static final Logger logger = LoggerFactory.getLogger(OwnerRestController.class);
	
    private final OwnerService ownerService;
    private final OwnerMapper ownerMapper;
    
    public OwnerRestController(OwnerService ownerService,
            OwnerMapper ownerMapper,
            PetMapper petMapper,
            VisitMapper visitMapper) {
		this.ownerService = ownerService;
		this.ownerMapper = ownerMapper;
	}
	
	@GetMapping("/owner")
    public ResponseEntity<List<OwnerDto>> listOwners(String lastName) {
		List<Owner> owners;
        if (lastName != null) {
            owners = ownerService.findByLastName(lastName);
        } else {
            owners = ownerService.findAll();
        }
        
        List<OwnerDto> ownerListDto = ownerMapper.toOwnerDtoList(owners);
        
        return new ResponseEntity<>(ownerListDto, HttpStatus.OK);
    }
	
	@GetMapping("/owner/{ownerId}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable("ownerId") Integer ownerId) {
        Owner owner = ownerService.findById(ownerId);
        
        logger.debug("\n### Owner : {}", owner);
        
        if (owner == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);        
        OwnerDto ownerDto = ownerMapper.toOwnerDto(owner);
        
        return new ResponseEntity<>(ownerDto, HttpStatus.OK);
    }

}
