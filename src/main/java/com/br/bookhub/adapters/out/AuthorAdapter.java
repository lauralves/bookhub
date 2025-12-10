package com.br.bookhub.adapters.out;

import com.br.bookhub.adapters.out.repository.AuthorRepository;
import com.br.bookhub.application.core.entities.Author;
import com.br.bookhub.application.ports.AuthorPort;
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
public class AuthorAdapter implements AuthorPort {

    private AuthorRepository authorRepository;

    @Override
    public Author insert(Author author) {
        log.info("Inserting author {}", author);
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author author) {
        log.info("Updating author {}", author);
        Author savedAuthor = authorRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Author not found"));
        savedAuthor.setName(author.getName());
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting author with id {}", id);
        authorRepository.deleteById(id);
    }

    @Override
    public Author findById(Long id) {
        log.info("Finding author with id {}", id);
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id " + id));
    }

    public Page<Author> findAll(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        log.info("Finding all authors");
        return authorRepository.findAll(PageRequest.of(page, size));
    }
}
