package net.guhya.petclinic.module.owner.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.owner.api.dto.PetDto;
import net.guhya.petclinic.module.owner.api.dto.PetTypeDto;
import net.guhya.petclinic.module.owner.data.Pet;
import net.guhya.petclinic.module.owner.data.PetType;

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
