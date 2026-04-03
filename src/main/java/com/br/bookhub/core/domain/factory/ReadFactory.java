package com.br.bookhub.core.domain.factory;

import com.br.bookhub.core.domain.entities.Read;

public class ReadFactory {
    public void update(Read read, Read resource) {
        read.setStartDate(read.getStartDate());
        read.setEndDate(read.getEndDate());
        read.setUpdatedAt(read.getUpdatedAt());
        read.setUpdatedBy(read.getUpdatedBy());
        read.setPagesRead(resource.getPagesRead());
    }
}
