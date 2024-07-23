package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.infrastructure.repo.CurrencyRepository;
import com.saaws88.chinacalc.service.CurrencyService;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CurrencyServiceImplementation implements CurrencyService {

  private final CurrencyRepository currencyRepository;

  public void addCurrencyRecord(CurrencyEntity currency) {
    
    currencyRepository.save(currency);
  
  }

  @Override
  public void updateCurrencyRate(CurrencyEntity currency) {


    Optional<CurrencyEntity> ce = currencyRepository.findByCode(currency.getCode());

    if (ce.isPresent()) {

      ce.get().setRate(currency.getRate());
      currencyRepository.save(ce.get());

    } else {
      
      currencyRepository.save(currency);    
    }
  
  }

  @Override
  public void deleteByCode(String code) {

    currencyRepository.deleteByCode(code);

  }

  @Override
  public CurrencyEntity getByCode(String code) {

    return currencyRepository.findByCode(code)
        .orElseThrow(() -> new ObjectNotFoundException("Валюта не найдена"));

  }

  @Override
  public List<CurrencyEntity> findAll() {
    
    return (List<CurrencyEntity>) currencyRepository.findAll();

  }

}
