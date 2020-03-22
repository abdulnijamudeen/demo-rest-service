package com.example.nizam.app.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USERNAME")
    private String username;
    @JsonIgnore
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    private String role;
    @JsonIgnore
    @Column(name = "CREATED_DATE")
    private Date createdDate;
}
