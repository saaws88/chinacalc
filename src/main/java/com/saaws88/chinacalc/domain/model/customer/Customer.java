package com.saaws88.chinacalc.domain.model.customer;

import com.saaws88.chinacalc.domain.model.customer.enumerated.CustomerCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Клиент
 */
@Table(name = "chinacalc_customer")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Customer {

  /**
   * Идентификатор клиента в БД
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private long id;
  /**
   * Частное лицо
   */
  @Column(name = "is_private_person", nullable = false)
  private boolean privatePerson;
  /**
   * Наименование клиента
   */
  @Column(name = "customer_name", nullable = false)
  private String customerName;
  /**
   * Фамилия контактного лица клиента
   */
  @Column(name = "contact_last_name", nullable = false)
  private String contactLastName;
  /**
   * Имя контактного лица клиента
   */
  @Column(name = "contact_first_name", nullable = false)
  private String contactFirstName;
  /**
   * Имя контактного лица клиента
   */
  @Column(name = "contact_patronymic")
  private String contactPatronymic;
  /**
   * Город местонахождения клиента
   */
  @Column(name = "city", nullable = false)
  private String city;
  /**
   * Электронная почта клиента
   */
  @Column(name = "email", nullable = false)
  private String email;
  /**
   * Номер телефона клиента
   */
  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;
  /**
   * Категория клиента (по количеству отправок через сервис)
   */
  @Column(name = "customer_category", nullable = false)
  private CustomerCategory category;
  /**
   * ИНН клиента
   */
  @Column(name = "taxpayer_number")
  private String taxpayerIdentificationNumber;

}
