package org.chinacalcweb.webgui.model;

import java.io.Serializable;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Currencies")
public class CurrencyEntity implements Serializable {

  @Id
  @AccessType(Type.PROPERTY)
  private String id;
  private String rates;
  
}
