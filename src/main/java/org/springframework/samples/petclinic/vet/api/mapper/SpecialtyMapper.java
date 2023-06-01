package org.springframework.samples.petclinic.vet.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.springframework.samples.petclinic.vet.api.dto.SpecialtyDto;
import org.springframework.samples.petclinic.vet.data.Specialty;

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
