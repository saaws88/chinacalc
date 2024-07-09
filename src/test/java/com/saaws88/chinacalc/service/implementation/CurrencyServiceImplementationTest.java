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

    CurrencyEntity usd = new CurrencyEntity(1L, "USD", 90.44);

    service.addCurrencyRecord(usd);

    verify(repo).save(usd);

  }

  @Test
  @DisplayName("Удаление по названию валюты происходит успешно")
  public void deleteByCode_currencyNameEqualsUsd_asIntended() {

    service.deleteByCode("usd");

    verify(repo).deleteByCode("usd");

  }

  @Test
  @DisplayName("Поиск валюты по имени работает находит корректную запись")
  public void getByCode_currencyNameEqualsUsd_asIntended() {

    CurrencyEntity usd = new CurrencyEntity(1L,"USD", 90.44);

    when(repo.findByCode("usd")).thenReturn(Optional.of(usd));

    CurrencyEntity supposedlyUsd = service.getByCode("usd");

    verify(repo).findByCode("usd");
    assertEquals(usd, supposedlyUsd);

  }

  @Test
  @DisplayName("Поиск несуществующей валюты по имени бросает исключение")
  public void getByCode_currencyNameEqualsCny_throwsException() {

    when(repo.findByCode("cny")).thenReturn(Optional.empty());

    assertThrows(ObjectNotFoundException.class, () -> service.getByCode("cny"));

  }

  @Test
  @DisplayName("Поиск всех валют возвращает 2 валюты")
  public void getAll_twoCurrencies_returnsTwoCurrencies() {

    List<CurrencyEntity> currencies = new ArrayList<>();

    currencies.add(new CurrencyEntity(1L,"usd", 90.44));
    currencies.add(new CurrencyEntity(2L, "cny", 12.72));

    when(repo.findAll()).thenReturn(currencies);

    assertEquals(currencies.size(), service.findAll().size());

  }


}


