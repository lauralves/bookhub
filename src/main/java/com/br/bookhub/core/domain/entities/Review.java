package com.br.bookhub.core.domain.entities;

import java.time.LocalDateTime;

public class Review {

    private Long id;
    private Integer starRating;
    private String overview;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private Read read;

    public Long getId() {
        return id;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public String getOverview() {
        return overview;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Read getRead() {
        return read;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setRead(Read read) {
        this.read = read;
    }
}
