package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.CurrencyEntity;

public interface CurrencyService {
  
  void addCurrencyRecord(CurrencyEntity currencyEntity);
  
  void deleteByCurrencyName(String currencyName);

  CurrencyEntity getByCurrencyName(String currencyName);

  List<CurrencyEntity> findAll();


}
