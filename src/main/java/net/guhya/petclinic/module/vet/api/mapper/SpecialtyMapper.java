package net.guhya.petclinic.module.vet.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.vet.api.dto.SpecialtyDto;
import net.guhya.petclinic.module.vet.data.Specialty;

/**
 * Map Specialty & SpecialtyDto using mapstruct
 */
@Mapper
public interface SpecialtyMapper {
    
	Specialty toSpecialty(SpecialtyDto specialtyDto);

    SpecialtyDto toSpecialtyDto(Specialty specialty);

    Collection<SpecialtyDto> toSpecialtyDtos(Collection<Specialty> specialties);

    Collection<Specialty> toSpecialtys(Collection<SpecialtyDto> specialties);

}
