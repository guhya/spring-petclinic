package net.guhya.petclinic.module.owner.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.owner.api.dto.OwnerDto;
import net.guhya.petclinic.module.owner.data.Owner;

/**
 * Maps Owner & OwnerDto using Mapstruct
 */

@Mapper(uses = VisitMapper.class)
public interface OwnerMapper {

    OwnerDto toOwnerDto(Owner owner);

    Owner toOwner(OwnerDto ownerDto);

    List<OwnerDto> toOwnerDtoList(List<Owner> ownerList);

    List<Owner> toOwners(List<OwnerDto> ownerDtos);
}
