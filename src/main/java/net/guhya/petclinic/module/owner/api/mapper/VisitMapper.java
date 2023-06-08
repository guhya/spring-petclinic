package net.guhya.petclinic.module.owner.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.owner.api.dto.request.VisitDto;
import net.guhya.petclinic.module.owner.data.Visit;

/**
 * Map Visit & VisitDto using mapstruct
 */
@Mapper
public interface VisitMapper {
    
    @Mapping(source = "petId", target = "pet.petId")
	Visit toVisit(VisitDto visitDto);

    @Mapping(source = "pet.petId", target = "petId")
    VisitDto toVisitDto(Visit visit);
}
