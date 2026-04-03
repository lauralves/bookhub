package com.br.bookhub.core.domain.factory;

import com.br.bookhub.core.domain.entities.Book;

import java.time.LocalDate;

public class BookFactory {
    public void update(Book book, Book resource) {
        if (resource.getPublishedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Publish date cannot be in the future");
        }
        book.setPublishedDate(resource.getPublishedDate());
        book.setName(resource.getName());
        book.setAuthor(resource.getAuthor());
        book.setTotalPages(resource.getTotalPages());
    }
}
