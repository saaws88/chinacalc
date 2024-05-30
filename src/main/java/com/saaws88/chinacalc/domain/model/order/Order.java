package com.saaws88.chinacalc.domain.model.order;

import java.time.LocalDateTime;

import com.saaws88.chinacalc.domain.model.customer.Customer;
import com.saaws88.chinacalc.domain.model.order.enumerated.OrderStatus;
import com.saaws88.chinacalc.domain.model.order.enumerated.PackageType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Заказ
 */
@Table(name = "chinacalc_order")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

  /**
   * Идентификатор
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  /**
   * Дата создания заказа
   */
  @CreationTimestamp
  @Column(name = "creation_date", updatable = false, nullable = false)
  private LocalDateTime creationDate;
  /**
   * Город получатель
   */
  @Column(name = "receiver_city", nullable = false)
  private String recieverCity;
  /**
   * Вес заказа, кг
   */
  @Column(name = "weight", nullable = false)
  private double weight;
  /**
   * Объем заказа, м3
   */
  @Column(name = "volume", nullable = false)
  private double volume;
  /**
   * Стоимость товара в заказе
   */
  @Column(name = "purchase_cost", nullable = false)
  private long purchaseCost;
  /**
   * Тип упаковки для заказа
   */
  @Column(name = "package_type", nullable = false)
  private PackageType packageType;
  /**
   * Статус заказа
   */
  @Column(name = "status", nullable = false)
  private OrderStatus status;
  /**
   * Идентификатор клиента
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;
  /**
   * Вес заказа в упаковке
   */
  @Column(name = "packaged_weight")
  private double packagedWeight;
  /**
   * Объем заказа в упаковке
   */
  @Column(name = "packaged_volume")
  private double packagedVolume;
  /**
   * Стоимость страховки
   */
  @Column(name = "insurance_cost")
  private double insuranceCost;
  /**
   * Стоимость доставки до сортера в Иу
   */
  @Column(name = "cost_to_yiwu")
  private double costToYiwu;
  /**
   * Стоимость доставки до сортера в Иу
   */
  @Column(name = "cost_to_russia_rur")
  private double costToRussia;
  /**
   * Общая стоимость
   */
  @Column(name = "total_cost")
  private double totalCost;
  /**
   * Ссылка на товар
   */
  @Column(name = "purchase_link")
  private String purchaseLink;

}
