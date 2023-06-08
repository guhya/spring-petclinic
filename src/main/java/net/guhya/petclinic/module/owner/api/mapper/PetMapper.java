package net.guhya.petclinic.module.owner.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.owner.api.dto.request.PetDto;
import net.guhya.petclinic.module.owner.data.Pet;

/**
 * Map Pet & PetDto using mapstruct
 */
@Mapper(uses = VisitMapper.class)
public interface PetMapper {

    @Mapping(source = "owner.ownerId", target = "ownerId")
    @Mapping(source = "type.typeId", target = "typeId")
    PetDto toPetDto(Pet pet);

    @Mapping(source = "ownerId", target = "owner.ownerId")
    @Mapping(source = "typeId", target = "type.typeId")
    Pet toPet(PetDto petDto);
}
