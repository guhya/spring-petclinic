package net.guhya.petclinic.module.owner.api.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.owner.api.dto.OwnerDto;
import net.guhya.petclinic.module.owner.data.Owner;

/**
 * Maps Owner & OwnerDto using Mapstruct
 */

@Mapper(uses = PetMapper.class)
public interface OwnerMapper {

    OwnerDto toOwnerDto(Owner owner);

    Owner toOwner(OwnerDto ownerDto);

    List<OwnerDto> toOwnerDtoList(Collection<Owner> ownerCollection);

    Collection<Owner> toOwners(Collection<OwnerDto> ownerDtos);
}
