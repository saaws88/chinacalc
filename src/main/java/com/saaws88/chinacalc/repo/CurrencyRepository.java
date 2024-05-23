package com.saaws88.chinacalc.repo;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity, String> { }
