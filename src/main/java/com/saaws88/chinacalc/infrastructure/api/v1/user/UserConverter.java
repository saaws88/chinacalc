package com.saaws88.chinacalc.infrastructure.api.v1.user;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.infrastructure.api.v1.user.dto.UserCreationDto;
import com.saaws88.chinacalc.infrastructure.api.v1.user.dto.UserResponseDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter{ 

  ChinacalcUser toEntity(UserCreationDto dto);
  UserResponseDto toDto(ChinacalcUser user);

}


