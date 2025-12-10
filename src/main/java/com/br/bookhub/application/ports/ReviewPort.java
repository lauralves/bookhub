package com.br.bookhub.application.ports;

import com.br.bookhub.application.core.entities.Review;

public interface ReviewPort {

    Review insert(Review review);
    Review update(Long id, Review review);
    void deleteById(Long id);
    Review findById(Long id);
}
