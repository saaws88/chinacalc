package com.saaws88.chinacalc.infrastructure.api.v1.customer;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.saaws88.chinacalc.domain.model.customer.Customer;
import com.saaws88.chinacalc.infrastructure.api.v1.customer.dto.CustomerCreationDto;
import com.saaws88.chinacalc.infrastructure.api.v1.customer.dto.CustomerResponseDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerConverter {
  
  Customer toEntity(CustomerCreationDto dto);
  CustomerResponseDto toDto(Customer enntity);

}
