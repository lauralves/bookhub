package com.br.bookhub.adapters.out;

import com.br.bookhub.adapters.out.repository.AuthorRepository;
import com.br.bookhub.adapters.out.repository.BookRepository;
import com.br.bookhub.application.core.entities.Book;
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
    private AuthorRepository authorRepository;

    @Override
    public Book insert(Book book) {
        log.info("Inserting book {}", book);
        var author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id " + book.getAuthor().getId()));
        book.setAuthor(author);
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
    public void deleteById(Long id) {
        log.info("Deleting book with id {}", id);
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(Long id) {
        log.info("Finding book with id {}", id);
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + id));
    }

    public Page<Book> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        log.info("Finding all books");
        return bookRepository.findAll(PageRequest.of(page, size));
    }
}
