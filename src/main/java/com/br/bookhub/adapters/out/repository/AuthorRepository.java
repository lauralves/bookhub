package com.br.bookhub.adapters.out.repository;

import com.br.bookhub.application.core.entities.Author;
import com.br.bookhub.application.core.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
