package com.br.bookhub.adapters.out;

import com.br.bookhub.adapters.out.repository.ReviewRepository;
import com.br.bookhub.application.core.entities.Review;
import com.br.bookhub.application.ports.ReviewPort;
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
public class ReviewAdapter implements ReviewPort {

    private ReviewRepository repository;
    
    @Override
    public Review insert(Review review) {
        log.info("Inserting review {}", review);
        return repository.save(review);
    }

    @Override
    public Review update(Long id, Review review) {
        log.info("Updating review {}", review);
        return repository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting review with id {}", id);
        repository.deleteById(id);
    }

    @Override
    public Review findById(Long id) {
        log.info("Finding review with id {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id " + id));
    }

    public Page<Review> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        log.info("Finding all reviews");
        return repository.findAll(PageRequest.of(page, size));
    }
}
