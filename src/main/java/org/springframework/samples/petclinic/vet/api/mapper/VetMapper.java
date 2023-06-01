package org.springframework.samples.petclinic.vet.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.springframework.samples.petclinic.vet.api.dto.VetDto;
import org.springframework.samples.petclinic.vet.data.Vet;

/**
 * Map Vet & VetoDto using mapstruct
 */
@Mapper(uses = SpecialtyMapper.class)
public interface VetMapper {
	
    Vet toVet(VetDto vetDto);

    VetDto toVetDto(Vet vet);

    Collection<VetDto> toVetDtos(Collection<Vet> vets);
}
