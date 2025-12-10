package com.br.bookhub.application.ports;

import com.br.bookhub.application.core.entities.Read;

public interface ReadPort {

    Read insert(Read read);
    Read update(Long id, Read read);
    void deleteById(Long id);
    Read findById(Long id);
}
