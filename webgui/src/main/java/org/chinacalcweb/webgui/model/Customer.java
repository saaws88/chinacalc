package org.chinacalcweb.webgui.model;

import java.util.List;

import org.chinacalcweb.webgui.model.Enums.CustomerCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "chinacalc_customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private long id;
  @Column(name = "is_private_person", nullable = false)
  private boolean isPrivatePerson;
  @Column(name = "customer_name", nullable = false)
  private String customerName;
  @Column(name = "contact_last_name", nullable = false)
  private String contactLastName;
  @Column(name = "contact_first_name", nullable = false)
  private String contactFirstName;
  @Column(name = "contact_patronymic")
  private String contactPatronymic;
  @Column(name = "city", nullable = false)
  private String city;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;
  @Column(name = "customer_category", nullable = false)
  private CustomerCategory category;
  @Column(name = "taxpayer_number")
  private Long individualTaxpayerNumber;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  private List<Order> orders;
}
