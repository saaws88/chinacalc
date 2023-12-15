package org.chinacalcweb.webgui.model;

import org.chinacalcweb.webgui.model.Enums.PackageType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Parcel {
  
  private long purchaseCostRur;
  private String purchaseLink;

  private String receiverCity;
  private Customer customer;

  private double weight;
  private double volume;
  private PackageType packageType;
  
}
