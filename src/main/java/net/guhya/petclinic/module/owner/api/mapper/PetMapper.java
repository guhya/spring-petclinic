package net.guhya.petclinic.module.owner.api.mapper;

import java.util.List;

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

    List<PetDto> toPetsDto(List<Pet> pets);

    List<Pet> toPets(List<PetDto> pets);

    Pet toPet(PetDto petDto);

    PetTypeDto toPetTypeDto(PetType petType);

    PetType toPetType(PetTypeDto petTypeDto);

    List<PetTypeDto> toPetTypeDtos(List<PetType> petTypes);
}
