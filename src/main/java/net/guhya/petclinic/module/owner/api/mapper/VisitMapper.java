package net.guhya.petclinic.module.owner.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.guhya.petclinic.module.owner.api.dto.VisitDto;
import net.guhya.petclinic.module.owner.data.Visit;

/**
 * Map Visit & VisitDto using mapstruct
 */
@Mapper
public interface VisitMapper {
    
	Visit toVisit(VisitDto visitDto);

    @Mapping(source = "pet.id", target = "petId")
    VisitDto toVisitDto(Visit visit);

    List<VisitDto> toVisitsDto(List<Visit> visits);

}
