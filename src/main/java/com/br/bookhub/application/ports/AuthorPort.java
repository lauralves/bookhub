package com.br.bookhub.application.ports;

import com.br.bookhub.application.core.entities.Author;

public interface AuthorPort {

    Author insert(Author author);
    Author update(Long id, Author author);
    void deleteById(Long id);
    Author findById(Long id);
}
