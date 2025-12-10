package com.br.bookhub.adapters.out.controller;

import com.br.bookhub.adapters.out.ReviewAdapter;
import com.br.bookhub.application.core.entities.Review;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/review")
@AllArgsConstructor
public class ReviewController {

    private ReviewAdapter reviewAdapter;

    @GetMapping()
    public ResponseEntity<Page<Review>> findAll(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(reviewAdapter.findAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewAdapter.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Review> insert(@RequestBody Review book) {
        return ResponseEntity.ok(reviewAdapter.insert(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, Review book) {
        return ResponseEntity.ok(reviewAdapter.update(id, book));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        reviewAdapter.deleteById(id);
    }


}
