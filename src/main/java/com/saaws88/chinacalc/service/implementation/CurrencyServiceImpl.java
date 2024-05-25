package com.saaws88.chinacalc.service.implementation;

import java.util.List;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.repo.CurrencyRepository;
import com.saaws88.chinacalc.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

  @Autowired
  private CurrencyRepository currencyRepository;

  @Override
  public void addCurrencyRecord(CurrencyEntity currency) {

    var currencyEntity = new CurrencyEntity();

    currencyEntity.setId(currency.getId());
    currencyEntity.setRates(currency.getRates());

    currencyRepository.save(currencyEntity);

  }

  @Override
  public void deleteByCurrencyName(String id) {

    currencyRepository.deleteById(id);

  }

  @Override
  public CurrencyEntity getByCurrencyName(String id) {

    return currencyRepository.findById(id)
        .orElseThrow(() -> new UsernameNotFoundException("Валюта не найдена"));

  }

  @Override
  public List<CurrencyEntity> findAll() {
    
    return (List<CurrencyEntity>) currencyRepository.findAll();

  }

}
