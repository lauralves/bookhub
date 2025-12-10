package com.br.bookhub.adapters.out.controller;

import com.br.bookhub.adapters.out.ReadAdapter;
import com.br.bookhub.application.core.entities.Read;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/read")
@AllArgsConstructor
public class ReadController {

    private ReadAdapter readAdapter;

    @GetMapping()
    public ResponseEntity<Page<Read>> findAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(readAdapter.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Read> findById(@PathVariable Long id) {
        return ResponseEntity.ok(readAdapter.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Read> insert(@RequestBody Read book) {
        return ResponseEntity.ok(readAdapter.insert(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Read> update(@PathVariable Long id, Read book) {
        return ResponseEntity.ok(readAdapter.update(id, book));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        readAdapter.deleteById(id);
    }


}
