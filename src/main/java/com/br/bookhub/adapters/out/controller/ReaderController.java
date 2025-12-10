package com.br.bookhub.adapters.out.controller;

import com.br.bookhub.adapters.out.ReaderAdapter;
import com.br.bookhub.application.core.entities.Reader;
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
    public ResponseEntity<Page<Reader>> findAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(readerAdapter.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reader> findById(@PathVariable Long id) {
        return ResponseEntity.ok(readerAdapter.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Reader> insert(@RequestBody Reader book) {
        return ResponseEntity.ok(readerAdapter.insert(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reader> update(@PathVariable Long id, Reader book) {
        return ResponseEntity.ok(readerAdapter.update(id, book));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        readerAdapter.deleteById(id);
    }


}
