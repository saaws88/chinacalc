package com.saaws88.chinacalc.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Тариф
 */
@NoArgsConstructor
@Getter
@Setter
public class Tariff {

  /**
   * Тариф до склада перевозчика в Хучжоу
   */
  private long costToHuzhou;

  /**
   * Тариф кросс-бордер по весу, константа
   */
  private static final long CROSSBOARDER_BY_WEIGHT = 350;
  /**
   * Тариф кросс-бордер по объему, константа
   */
  private static final long CROSSBOARDER_BY_VOLUME = 38000;

}
