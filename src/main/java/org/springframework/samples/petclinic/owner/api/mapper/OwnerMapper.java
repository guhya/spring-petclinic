package org.springframework.samples.petclinic.owner.api.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.samples.petclinic.owner.api.request.OwnerDto;
import org.springframework.samples.petclinic.owner.data.Owner;

/**
 * Maps Owner & OwnerDto using Mapstruct
 */
@Mapper(uses = PetMapper.class)
public interface OwnerMapper {

    OwnerDto toOwnerDto(Owner owner);

    Owner toOwner(OwnerDto ownerDto);

    List<OwnerDto> toOwnerDtoCollection(Collection<Owner> ownerCollection);

    Collection<Owner> toOwners(Collection<OwnerDto> ownerDtos);
}
