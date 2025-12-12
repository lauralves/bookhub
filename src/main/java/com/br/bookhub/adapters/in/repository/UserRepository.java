package com.br.bookhub.adapters.in.repository;

import com.br.bookhub.adapters.in.auth.UserDetailImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetailImpl, Long> {

    Optional<UserDetailImpl> findByEmail(String email);
}
