package org.chinacalcweb.webgui.model;

import java.time.LocalDateTime;

import org.chinacalcweb.webgui.model.Enums.OrderStatus;
import org.chinacalcweb.webgui.model.Enums.PackageType;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "chinacalc_orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  @CreationTimestamp
  @Column(name = "creation_date", updatable = false, nullable = false)
  private LocalDateTime creationDate;
  @Column(name = "receiver_city", nullable = false)
  private String recieverCity;
  @Column(name = "weight", nullable = false)
  private double weight;
  @Column(name = "volume", nullable = false)
  private double volume;
  @Column(name = "purchase_cost", nullable = false)
  private long purchaseCost;
  @Column(name = "package_type", nullable = false)
  private PackageType packageType;
  @Column(name = "status", nullable = false)
  private OrderStatus status;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;
  @Column(name = "packaged_weight")
  private double packagedWeight;
  @Column(name = "packaged_volume")
  private double packagedVolume;
  @Column(name = "insurence_cost")
  private double insuranceCost;
  @Column(name = "cost_to_yiwu")
  private double costToYiwu;
  @Column(name = "cost_to_russia_rur")
  private double costToRussia;
  @Column(name = "total_cost")
  private double totalCost;
  @Column(name = "purchase_link")
  private String purchaseLink;

}
