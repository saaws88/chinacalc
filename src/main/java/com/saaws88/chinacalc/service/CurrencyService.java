package com.saaws88.chinacalc.service;

import java.util.List;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;

public interface CurrencyService {
  
  void addCurrencyRecord(CurrencyEntity currencyEntity);

  void updateCurrencyRate(CurrencyEntity currency);
  
  void deleteByCode(String code);

  CurrencyEntity getByCode(String code);

  List<CurrencyEntity> findAll();

}
