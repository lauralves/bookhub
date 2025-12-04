package com.br.bookhub.adapters.out;

import com.br.bookhub.adapters.out.repository.BookRepository;
import com.br.bookhub.application.core.entities.Book;
import com.br.bookhub.application.ports.BookPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class BookAdapter implements BookPort {

    private BookRepository bookRepository;

    @Override
    public Book insert(Book book) {
        log.info("Inserting book {}", book);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        log.info("Updating book {}", book);
        Book savedBook = bookRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        savedBook.update(book);
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        log.info("Deleting book with id {}", book.getId());
        bookRepository.delete(book);
    }

    @Override
    public Book findById(Long id) {
        return null;
    }
}
