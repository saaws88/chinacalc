package org.chinacalcweb.webgui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tariff {

  private long costToHuzhou; 

  private long crossBoarderByWeight = 350;
  private long crossBoarderByVolume = 38000;

}
