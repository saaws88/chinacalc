package org.chinacalcweb.webgui.service.Implementations;

import java.util.List;

import org.chinacalcweb.webgui.model.CurrencyEntity;
import org.chinacalcweb.webgui.repo.CurrencyRepository;
import org.chinacalcweb.webgui.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyServiceImplementation implements CurrencyService {

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
