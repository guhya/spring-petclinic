package net.guhya.petclinic.module.vet.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.vet.api.request.VetSpecialtyDto;
import net.guhya.petclinic.module.vet.data.VetSpecialty;

/**
 * Map Vet & VetoDto using mapstruct
 */
@Mapper
public interface VetSpecialtyMapper {
	
    VetSpecialty toVetSpecialty(VetSpecialtyDto vetSpecialtyDto);

    @Mapping(source = "vetSpecialtyKey.vetId", target = "vetId")
    @Mapping(source = "vetSpecialtyKey.specialtyId", target = "specialtyId")
    VetSpecialtyDto toVetSpecialtyDto(VetSpecialty vet);
}
