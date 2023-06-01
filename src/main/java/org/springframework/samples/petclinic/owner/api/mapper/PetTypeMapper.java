package org.springframework.samples.petclinic.owner.api.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.samples.petclinic.owner.api.dto.PetTypeDto;
import org.springframework.samples.petclinic.owner.data.PetType;

/**
 * Map PetType & PetTypeDto using mapstruct
 */
@Mapper
public interface PetTypeMapper {

    PetType toPetType(PetTypeDto petTypeDto);

    PetTypeDto toPetTypeDto(PetType petType);

    List<PetTypeDto> toPetTypeDtos(Collection<PetType> petTypes);
}
