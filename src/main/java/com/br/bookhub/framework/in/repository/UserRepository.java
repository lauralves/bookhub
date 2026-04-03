package com.br.bookhub.framework.in.repository;

import com.br.bookhub.framework.in.security.UserDetailImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetailImpl, Long> {

    Optional<UserDetailImpl> findByEmail(String email);
}
