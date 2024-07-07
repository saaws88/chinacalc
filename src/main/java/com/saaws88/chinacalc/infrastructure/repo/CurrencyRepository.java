package com.saaws88.chinacalc.infrastructure.repo;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity, Long> {

  Optional<CurrencyEntity> findByCode(String code);

  void deleteByCode(String code);

}
