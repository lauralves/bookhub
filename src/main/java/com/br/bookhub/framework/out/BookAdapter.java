package com.br.bookhub.framework.out;

import com.br.bookhub.framework.out.entities.BookEntity;
import com.br.bookhub.framework.out.factory.BookFactory;
import com.br.bookhub.framework.out.repository.AuthorRepository;
import com.br.bookhub.framework.out.repository.BookRepository;
import com.br.bookhub.core.domain.entities.Book;
import com.br.bookhub.application.ports.BookPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@AllArgsConstructor
@Component
public class BookAdapter implements BookPort {

    private BookRepository bookRepository;

    @Override
    public Book insert(Book book) {
        log.info("Inserting book {}", book);
        BookEntity entity = BookFactory.toEntity(book);
        BookEntity saved = bookRepository.save(entity);
        return BookFactory.toDomain(saved);
    }

    @Override
    public Book update(Long id, Book book) {
        log.info("Updating book {}", book);
        BookEntity savedBook = bookRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        BookEntity entity = BookFactory.update(savedBook, book);
        bookRepository.save(entity);
        return BookFactory.toDomain(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting book with id {}", id);
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        log.info("Finding book with id {}", id);
        var entity = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
        return BookFactory.toDomain(entity);
    }

    public Page<Book> findAll(int page,
                              int size) {
        log.info("Finding all books");
        return bookRepository.findAll(PageRequest.of(page, size))
                .map(BookFactory::toDomain);
    }
}
