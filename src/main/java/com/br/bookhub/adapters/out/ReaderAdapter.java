package com.br.bookhub.adapters.out;

import com.br.bookhub.adapters.out.repository.ReaderRepository;
import com.br.bookhub.application.core.entities.Reader;
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

    private ReaderRepository repository;
    
    @Override
    public Reader insert(Reader reader) {
        log.info("Inserting user {}", reader);
        return repository.save(reader);
    }

    @Override
    public Reader update(Long id, Reader reader) {
        log.info("Updating user {}", reader);
        return repository.save(reader);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting user with id {}", id);
        repository.deleteById(id);
    }

    @Override
    public Reader findById(Long id) {
        log.info("Finding user with id {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public Page<Reader> findAll(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        log.info("Finding all users");
        return repository.findAll(PageRequest.of(page, size));
    }
}
