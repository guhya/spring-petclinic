package net.guhya.petclinic.module.owner.api.mapper;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.owner.api.dto.request.PetTypeDto;
import net.guhya.petclinic.module.owner.data.PetType;

/**
 * Map PetType & PetTypeDto using mapstruct
 */
@Mapper
public interface PetTypeMapper {

    PetType toPetType(PetTypeDto petTypeDto);

    PetTypeDto toPetTypeDto(PetType petType);
}
