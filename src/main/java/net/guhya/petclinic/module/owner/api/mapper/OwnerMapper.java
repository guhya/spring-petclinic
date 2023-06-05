package net.guhya.petclinic.module.owner.api.mapper;

import org.mapstruct.Mapper;

import net.guhya.petclinic.module.owner.api.dto.request.OwnerDto;
import net.guhya.petclinic.module.owner.data.Owner;

/**
 * Maps Owner & OwnerDto using Mapstruct
 */

@Mapper(uses = PetMapper.class)
public interface OwnerMapper {

    OwnerDto toOwnerDto(Owner owner);

    Owner toOwner(OwnerDto ownerDto);
}
