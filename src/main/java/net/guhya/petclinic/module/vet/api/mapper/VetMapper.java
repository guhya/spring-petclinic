package net.guhya.petclinic.module.vet.api.mapper;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.vet.api.request.VetDto;
import net.guhya.petclinic.module.vet.data.Vet;

/**
 * Map Vet & VetoDto using mapstruct
 */
@Mapper
public interface VetMapper {
	
    Vet toVet(VetDto vetDto);

    VetDto toVetDto(Vet vet);
}
