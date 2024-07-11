package com.saaws88.chinacalc.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Валюта
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "currency")
public class CurrencyEntity {

  /**
   * Идентификатор валюты в БД, ключ
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * Код валюты в формате ISO 4217
   */
  @Column(name = "code")
  private String code;
  /**
   * Курс валюты
   */
  @Column(name = "rate")
  private Double rate;

}
