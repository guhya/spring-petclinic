package net.guhya.petclinic.module.owner.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.owner.api.dto.PetTypeDto;
import net.guhya.petclinic.module.owner.data.PetType;

/**
 * Map PetType & PetTypeDto using mapstruct
 */
@Mapper
public interface PetTypeMapper {

    PetType toPetType(PetTypeDto petTypeDto);

    PetTypeDto toPetTypeDto(PetType petType);

    List<PetTypeDto> toPetTypeDtos(List<PetType> petTypes);
}
