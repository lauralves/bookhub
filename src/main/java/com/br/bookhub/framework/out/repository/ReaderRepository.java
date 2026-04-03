package com.br.bookhub.framework.out.repository;

import com.br.bookhub.core.domain.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
