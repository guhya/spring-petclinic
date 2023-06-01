package org.springframework.samples.petclinic.owner.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.samples.petclinic.owner.api.request.VisitDto;
import org.springframework.samples.petclinic.owner.data.Visit;

/**
 * Map Visit & VisitDto using mapstruct
 */
@Mapper(uses = PetMapper.class)
public interface VisitMapper {
    
	Visit toVisit(VisitDto visitDto);

    @Mapping(source = "pet.id", target = "petId")
    VisitDto toVisitDto(Visit visit);

    Collection<VisitDto> toVisitsDto(Collection<Visit> visits);

}
