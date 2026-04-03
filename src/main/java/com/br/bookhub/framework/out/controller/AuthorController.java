package com.br.bookhub.framework.out.controller;

import com.br.bookhub.framework.out.AuthorAdapter;
import com.br.bookhub.core.domain.entities.Author;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/author")
@AllArgsConstructor
@SecurityRequirement(name = "authorization")
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
