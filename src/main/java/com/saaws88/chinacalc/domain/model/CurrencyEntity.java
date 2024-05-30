package com.saaws88.chinacalc.domain.model;

import java.io.Serializable;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.redis.core.RedisHash;

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
@RedisHash("Currencies")
public class CurrencyEntity implements Serializable {

  /**
   * Код валюты, ключ
   */
  @Id
  @AccessType(Type.PROPERTY)
  private String id;
  /**
   * Курс валюты
   */
  private String rates;

}
