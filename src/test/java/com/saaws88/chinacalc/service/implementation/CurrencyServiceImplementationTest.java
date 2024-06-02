package com.saaws88.chinacalc.service.implementation;

import com.saaws88.chinacalc.domain.model.CurrencyEntity;
import com.saaws88.chinacalc.infrastructure.repo.CurrencyRepository;
import com.saaws88.chinacalc.service.implementation.exception.ObjectNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceImplementationTest {

  @InjectMocks
  CurrencyServiceImplementation service;
  @Mock
  CurrencyRepository repo;

  @Test
  @DisplayName("Создание записи о валюте с валидными данными работает")
  public void addCurrencyRecord_addCurrency_saved() {

    CurrencyEntity usd = new CurrencyEntity("USD", "9044");

    service.addCurrencyRecord(usd);

    verify(repo).save(usd);

  }

  @Test
  @DisplayName("Удаление по названию валюты происходит успешно")
  public void deleteByCurrencyName_currencyNameEqualsUsd_asIntended() {

    service.deleteByCurrencyName("usd");

    verify(repo).deleteById("usd");

  }

  @Test
  @DisplayName("Поиск валюты по имени работает находит корректную запись")
  public void getByCurrencyName_currencyNameEqualsUsd_asIntended() {

    CurrencyEntity usd = new CurrencyEntity("USD", "9044");

    when(repo.findById("usd")).thenReturn(Optional.of(usd));

    CurrencyEntity supposedlyUsd = service.getByCurrencyName("usd");

    verify(repo).findById("usd");
    assertEquals(usd, supposedlyUsd);

  }

  @Test
  @DisplayName("Поиск несуществующей валюты по имени бросает исключение")
  public void getByCurrencyName_currencyNameEqualsCny_throwsException() {

    when(repo.findById("cny")).thenReturn(Optional.empty());

    assertThrows(ObjectNotFoundException.class, () -> service.getByCurrencyName("cny"));

  }

  @Test
  @DisplayName("Поиск всех валют возвращает 2 валюты")
  public void getAll_twoCurrencies_returnsTwoCurrencies() {

    List<CurrencyEntity> currencies = new ArrayList<>();

    currencies.add(new CurrencyEntity("usd", "9044"));
    currencies.add(new CurrencyEntity("cny", "1272"));

    when(repo.findAll()).thenReturn(currencies);

    assertEquals(currencies.size(), service.findAll().size());

  }


}


