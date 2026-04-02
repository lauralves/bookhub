package com.br.bookhub.application.core.factory;

import com.br.bookhub.application.core.entities.Read;

public class ReadFactory {
    public void update(Read read, Read resource) {
        read.setStartDate(read.getStartDate());
        read.setEndDate(read.getEndDate());
        read.setUpdatedAt(read.getUpdatedAt());
        read.setUpdatedBy(read.getUpdatedBy());
        read.setPagesRead(resource.getPagesRead());
    }
}
