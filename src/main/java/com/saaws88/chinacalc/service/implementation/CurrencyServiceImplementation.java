package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.infrastructure.repo.CurrencyRepository;
import com.saaws88.chinacalc.service.CurrencyService;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyServiceImplementation implements CurrencyService {

  @Autowired
  private CurrencyRepository currencyRepository;

  @Override
  public void addCurrencyRecord(CurrencyEntity currency) {

    currencyRepository.save(currency);

  }

  @Override
  public void deleteByCurrencyName(String id) {

    currencyRepository.deleteById(id);

  }

  @Override
  public CurrencyEntity getByCurrencyName(String id) {

    return currencyRepository.findById(id)
        .orElseThrow(() -> new ObjectNotFoundException("Валюта не найдена"));

  }

  @Override
  public List<CurrencyEntity> findAll() {
    
    return (List<CurrencyEntity>) currencyRepository.findAll();

  }

}
