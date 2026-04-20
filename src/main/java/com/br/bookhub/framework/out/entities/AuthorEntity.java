package com.br.bookhub.framework.out.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "author")
public class AuthorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String name;
}
