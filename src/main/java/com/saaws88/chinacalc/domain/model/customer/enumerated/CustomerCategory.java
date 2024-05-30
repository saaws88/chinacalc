package com.saaws88.chinacalc.domain.model.customer.enumerated;

/**
 * Категория клиента
 */
public enum CustomerCategory {

  /**
   * Первичный клиент - 0 отправок
   */
  INITIAL,

  /**
   * Вторичный клиент - 1-3 отправки
   */
  SECONDARY,

  /**
   * Регулярный клиент
   */
  REGULAR
}
