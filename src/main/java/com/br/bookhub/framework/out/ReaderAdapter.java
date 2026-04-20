package com.br.bookhub.framework.out;

import com.br.bookhub.core.domain.entities.User;
import com.br.bookhub.framework.out.repository.UserRepository;
import com.br.bookhub.application.ports.ReaderPort;
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
public class ReaderAdapter implements ReaderPort {

    private UserRepository repository;
    
    @Override
    public User insert(User user) {
        log.info("Inserting user {}", user);
        return repository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        log.info("Updating user {}", user);
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting user with id {}", id);
        repository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        log.info("Finding user with id {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public Page<User> findAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        log.info("Finding all users");
        return repository.findAll(PageRequest.of(page, size));
    }
}
