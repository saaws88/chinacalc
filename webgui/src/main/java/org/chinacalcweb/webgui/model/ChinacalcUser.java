package org.chinacalcweb.webgui.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="chinacalc_users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ChinacalcUser {

  @Id
  @SequenceGenerator(name="usr_seq", sequenceName = "users_sequence", initialValue = 1, allocationSize = 10)
  @GeneratedValue(strategy=GenerationType.SEQUENCE)
  @Column(name="id",nullable=false,unique=true)
  private long id;
  @Column(name="email",nullable=false,unique=true)
  private String email;
  @Column(name="username",nullable=false,unique=true)
  private String username;
  @Column(name="password",nullable=false)
  private String password;
  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles = new HashSet<>();

}