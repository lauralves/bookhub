package com.br.bookhub.framework.out.controller;

import com.br.bookhub.core.domain.entities.User;
import com.br.bookhub.framework.out.ReaderAdapter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/reader")
@AllArgsConstructor
public class ReaderController {

    private ReaderAdapter readerAdapter;

    @GetMapping()
    public ResponseEntity<Page<User>> findAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(readerAdapter.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(readerAdapter.findById(id));
    }

    @PostMapping()
    public ResponseEntity<User> insert(@RequestBody User book) {
        return ResponseEntity.ok(readerAdapter.insert(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, User book) {
        return ResponseEntity.ok(readerAdapter.update(id, book));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        readerAdapter.deleteById(id);
    }


}
