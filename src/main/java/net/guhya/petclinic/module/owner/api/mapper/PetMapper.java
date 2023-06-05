package net.guhya.petclinic.module.owner.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.owner.api.dto.request.PetDto;
import net.guhya.petclinic.module.owner.api.dto.request.PetTypeDto;
import net.guhya.petclinic.module.owner.data.Pet;
import net.guhya.petclinic.module.owner.data.PetType;

/**
 * Map Pet & PetDto using mapstruct
 */
@Mapper(uses = VisitMapper.class)
public interface PetMapper {

    @Mapping(source = "owner.ownerId", target = "ownerId")
    @Mapping(source = "type.typeId", target = "typeId")
    PetDto toPetDto(Pet pet);

    List<PetDto> toPetsDto(List<Pet> pets);

    List<Pet> toPets(List<PetDto> pets);

    @Mapping(source = "ownerId", target = "owner.ownerId")
    @Mapping(source = "typeId", target = "type.typeId")
    Pet toPet(PetDto petDto);

    PetTypeDto toPetTypeDto(PetType petType);

    PetType toPetType(PetTypeDto petTypeDto);

    List<PetTypeDto> toPetTypeDtos(List<PetType> petTypes);
}
