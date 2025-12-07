package com.br.bookhub.adapters.out.controller;

import com.br.bookhub.adapters.out.BookAdapter;
import com.br.bookhub.application.core.entities.Book;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/book")
@AllArgsConstructor
public class BookController {

    private BookAdapter bookAdapter;

    @GetMapping()
    public ResponseEntity<Page<Book>> findAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(bookAdapter.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok(bookAdapter.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Book> insert(@RequestBody Book book) {
        return ResponseEntity.ok(bookAdapter.insert(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, Book book) {
        return ResponseEntity.ok(bookAdapter.update(id, book));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        bookAdapter.deleteById(id);
    }


}
