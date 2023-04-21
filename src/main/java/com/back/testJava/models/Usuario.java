package com.back.testJava.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "usuarios",  uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@Data @NoArgsConstructor
public class Usuario {

    @Column(name = "id")
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

}
