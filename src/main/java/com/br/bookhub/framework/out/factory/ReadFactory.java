package com.br.bookhub.framework.out.factory;

import com.br.bookhub.core.domain.entities.Book;
import com.br.bookhub.core.domain.entities.Read;
import com.br.bookhub.framework.out.entities.BookEntity;
import com.br.bookhub.framework.out.entities.ReadEntity;

public class ReadFactory {

    public static ReadEntity toEntity(Read read) {
        ReadEntity entity = new ReadEntity();
        entity.setPagesRead(read.getPagesRead());
        entity.setStartDate(read.getStartDate());
        entity.setEndDate(read.getEndDate());
        return entity;
    }

    public static Read toDomain(ReadEntity entity) {
        Read read = new Read();
        read.setPagesRead(entity.getPagesRead());
        read.setStartDate(entity.getStartDate());
        read.setEndDate(entity.getEndDate());
        return read;
    }
    
    public static void update(ReadEntity read, Read resource) {
        read.setStartDate(resource.getStartDate());
        read.setEndDate(resource.getEndDate());
        read.setPagesRead(resource.getPagesRead());
    }
}
