package com.br.bookhub.application.ports;

import com.br.bookhub.application.core.entities.Book;

public interface BookPort {

    Book insert(Book book);
    Book update(Long id, Book book);
    void deleteById(Long id);
    Book findById(Long id);
}
