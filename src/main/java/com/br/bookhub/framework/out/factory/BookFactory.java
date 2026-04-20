package com.br.bookhub.framework.out.factory;

import com.br.bookhub.core.domain.entities.Book;
import com.br.bookhub.framework.out.entities.BookEntity;

import java.time.LocalDate;

public class BookFactory {

    public static BookEntity toEntity(Book book) {
        BookEntity entity = new BookEntity();
        entity.setName(book.getName());
        entity.setPublishedDate(book.getPublishedDate());
        entity.setTotalPages(book.getTotalPages());
        return entity;
    }

    public static Book toDomain(BookEntity entity) {
        Book book = new Book();
        book.setName(entity.getName());
        book.setPublishedDate(entity.getPublishedDate());
        book.setTotalPages(entity.getTotalPages());
        return book;
    }

    public static BookEntity update(BookEntity entity, Book resource) {
        if (resource.getPublishedDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Publish date cannot be in the future");
        }
        entity.setPublishedDate(resource.getPublishedDate());
        entity.setName(resource.getName());
        entity.setTotalPages(resource.getTotalPages());
        return entity;
    }
}
