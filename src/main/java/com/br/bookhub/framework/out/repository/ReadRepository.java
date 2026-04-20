package com.br.bookhub.framework.out.repository;

import com.br.bookhub.framework.out.entities.ReadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadRepository extends JpaRepository<ReadEntity, Long> {
}
