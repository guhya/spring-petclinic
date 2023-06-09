package net.guhya.petclinic.module.vet.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.vet.api.request.VetDto;
import net.guhya.petclinic.module.vet.data.Vet;

/**
 * Map Vet & VetoDto using mapstruct
 */
@Mapper(uses = VetSpecialtyMapper.class)
public interface VetMapper {
	
    @Mapping(target = "specialties", ignore = true)
    Vet toVet(VetDto vetDto);

    VetDto toVetDto(Vet vet);
}
