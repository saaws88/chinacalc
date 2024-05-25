package com.saaws88.chinacalc.service;

import java.util.List;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;

public interface CurrencyService {
  
  void addCurrencyRecord(CurrencyEntity currencyEntity);
  
  void deleteByCurrencyName(String currencyName);

  CurrencyEntity getByCurrencyName(String currencyName);

  List<CurrencyEntity> findAll();


}
