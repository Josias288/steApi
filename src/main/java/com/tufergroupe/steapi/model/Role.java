package com.tufergroupe.steapi.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

@Data
@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", updatable = false, nullable = false)
    private int id;

    @Column(name = "ROLE_NAME", updatable = true, nullable = false)
    private String roleName;

}
