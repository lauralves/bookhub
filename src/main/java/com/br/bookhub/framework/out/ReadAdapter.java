package com.br.bookhub.framework.out;

import com.br.bookhub.framework.out.entities.ReadEntity;
import com.br.bookhub.framework.out.factory.ReadFactory;
import com.br.bookhub.framework.out.repository.ReadRepository;
import com.br.bookhub.core.domain.entities.Read;
import com.br.bookhub.application.ports.ReadPort;
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
public class ReadAdapter implements ReadPort {

    private ReadRepository repository;
    
    @Override
    public Read insert(Read read) {
        log.info("Inserting read {}", read);
        ReadEntity entity = ReadFactory.toEntity(read);
        var saved = repository.save(entity);
        return ReadFactory.toDomain(saved);
    }

    @Override
    public Read update(Long id, Read read) {
        log.info("Updating read {}", read);
        Read savedRead = repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Read not found"));
        ReadFactory.update(savedRead, read);
        return repository.save(read);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting read with id {}", id);
        repository.deleteById(id);
    }

    @Override
    public Read findById(Long id) {
        log.info("Finding read with id {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Read not found with id " + id));
    }

    public Page<Read> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        log.info("Finding all reads");
        return repository.findAll(PageRequest.of(page, size));
    }
}
