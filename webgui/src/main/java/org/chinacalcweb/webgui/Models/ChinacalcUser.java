package org.chinacalcweb.webgui.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Table(name="chinacalc_users")
@Entity
@Data
public class ChinacalcUser {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id",nullable=false,unique=true)
    private long id;
    @Column(name="name",nullable=false)
    private String name;
    @Column(name="email",nullable=true)
    private String email;
    @Column(name="login",nullable=false)
    private String login;
    @Column(name="password",nullable=false)
    private String password;
    @Column (name="role",nullable=false)
    private Role role;
}