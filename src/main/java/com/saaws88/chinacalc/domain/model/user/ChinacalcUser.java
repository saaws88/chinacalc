package com.saaws88.chinacalc.domain.model.user;

import java.util.HashSet;
import java.util.Set;

import com.saaws88.chinacalc.domain.model.user.enumerated.Role;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Пользователь
 */
@Table(name = "chinacalc_users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChinacalcUser {

  /**
   * Идентификатор пользователя в БД
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private long id;
  /**
   * Электронная почта пользователя
   */
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  /**
   * Юзернейм пользователя (равен электронной почте)
   */
  @Column(name = "username", nullable = false, unique = true)
  private String username;
  /**
   * Пароль пользователя
   */
  @Column(name = "password", nullable = false)
  private String password;
  /**
   * Роли пользователя
   */
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  private Set<Role> roles = new HashSet<>();
  /**
   * Аккаунт активен
   */
  @Column(name = "acc_not_expired", nullable = false)
  private boolean accountNonExpired;
  /**
   * Аккаунт не заблокирован
   */
  @Column(name = "acc_not_locked", nullable = false)
  private boolean accountNonLocked;
  /**
   * Данные для доступа аккаунта активны
   */
  @Column(name = "creds_not_expired", nullable = false)
  private boolean credentialsNonExpired;


  public ChinacalcUser(String email) {
    this.email = email;
  }
}
