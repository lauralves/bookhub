package com.br.bookhub.adapters.out.repository;

import com.br.bookhub.application.core.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
