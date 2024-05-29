package com.saaws88.chinacalc.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Tariff {

  private long costToHuzhou; 

  private static final long CROSSBOARDER_BY_WEIGHT = 350;
  private static final long CROSSBOARDER_BY_VOLUME = 38000;

  Tariff(long costToHuzhou) {
    this.costToHuzhou = costToHuzhou;
  }

}
