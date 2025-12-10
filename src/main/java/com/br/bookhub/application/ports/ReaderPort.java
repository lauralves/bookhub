package com.br.bookhub.application.ports;

import com.br.bookhub.application.core.entities.Reader;

public interface ReaderPort {

    Reader insert(Reader reader);
    Reader update(Long id, Reader reader);
    void deleteById(Long id);
    Reader findById(Long id);
}
