package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.CurrencyEntity;

public interface CurrencyService {
  
  public void addCurrencyRecord(CurrencyEntity currencyEntity);
  
  public void deleteByCurrencyName(String currencyName);

  public CurrencyEntity getByCurrencyName(String currencyName);

  public List<CurrencyEntity> findAll();


}
