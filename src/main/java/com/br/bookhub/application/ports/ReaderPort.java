package com.br.bookhub.application.ports;

import com.br.bookhub.core.domain.entities.User;

public interface ReaderPort {

    User insert(User user);
    User update(Long id, User user);
    void deleteById(Long id);
    User findById(Long id);
}
