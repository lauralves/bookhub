package com.br.bookhub.framework.out.repository;

import com.br.bookhub.core.domain.entities.User;
import com.br.bookhub.framework.out.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
