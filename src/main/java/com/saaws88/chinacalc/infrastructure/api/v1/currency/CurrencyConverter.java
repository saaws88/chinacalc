package com.saaws88.chinacalc.infrastructure.api.v1.currency;

import org.mapstruct.Mapper;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;

@Mapper(componentModel = "spring")
public interface CurrencyConverter {

  CurrencyEntity toEntity(CurrencyDto dto);
  CurrencyDto toDto(CurrencyEntity entity);
  
}
