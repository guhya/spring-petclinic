package org.springframework.samples.petclinic.owner.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.samples.petclinic.owner.api.dto.PetDto;
import org.springframework.samples.petclinic.owner.api.dto.PetTypeDto;
import org.springframework.samples.petclinic.owner.data.Pet;
import org.springframework.samples.petclinic.owner.data.PetType;

/**
 * Map Pet & PetDto using mapstruct
 */
@Mapper
public interface PetMapper {

    @Mapping(source = "owner.id", target = "ownerId")
    PetDto toPetDto(Pet pet);

    Collection<PetDto> toPetsDto(Collection<Pet> pets);

    Collection<Pet> toPets(Collection<PetDto> pets);

    Pet toPet(PetDto petDto);

    PetTypeDto toPetTypeDto(PetType petType);

    PetType toPetType(PetTypeDto petTypeDto);

    Collection<PetTypeDto> toPetTypeDtos(Collection<PetType> petTypes);
}
