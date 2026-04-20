package com.br.bookhub.framework.out.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_rating")
    private Integer starRating;

    @Column(name = "overview")
    private String overview;


}
