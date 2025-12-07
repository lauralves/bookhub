package com.br.bookhub.adapters.out.controller;

import com.br.bookhub.adapters.out.AuthorAdapter;
import com.br.bookhub.adapters.out.BookAdapter;
import com.br.bookhub.application.core.entities.Author;
import com.br.bookhub.application.core.entities.Author;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/author")
@AllArgsConstructor
public class AuthorController {

    private AuthorAdapter authorAdapter;

    @GetMapping()
    public ResponseEntity<Page<Author>> findAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(authorAdapter.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return ResponseEntity.ok(authorAdapter.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Author> insert(@RequestBody Author book) {
        return ResponseEntity.ok(authorAdapter.insert(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, Author book) {
        return ResponseEntity.ok(authorAdapter.update(id, book));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        authorAdapter.deleteById(id);
    }


}
