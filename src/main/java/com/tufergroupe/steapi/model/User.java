package com.tufergroupe.steapi.model;

import java.util.*;

import javax.persistence.*;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name = "utilisateurs")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "LOGIN", unique = true, insertable = true, updatable = true, nullable = false)
    private String login;

    private String email;

    private String password;

    @Column(name = "USER_ACTIVE", insertable = true, updatable = true, nullable = false)
    private Integer active;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();
}