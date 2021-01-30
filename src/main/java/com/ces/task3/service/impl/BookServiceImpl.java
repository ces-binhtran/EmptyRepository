package com.ces.task3.service.impl;

import com.ces.task3.dao.BookDAO;
import com.ces.task3.dao.TypeDAO;
import com.ces.task3.dto.BookDTO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.entity.TypeEntity;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookServiceImpl extends BaseServiceImpl<BookDAO, BookDTO, BookEntity, Integer> implements BookService {


    private final TypeDAO typeDAO;
    @Autowired
    public BookServiceImpl(BookDAO dao,
                           ModelMapper modelMapper,
                           TypeDAO typeDAO) {
        super(dao, modelMapper);
        this.typeDAO = typeDAO;
    }


    @Override
    public BookDTO create(BookEntity entity) throws NotFoundException {
        Integer typeId = entity.getType().getId();
        TypeEntity type = typeDAO.getById(typeId)
                .orElseThrow(() -> new NotFoundException("Id", typeId.toString()));
        entity.setType(type);
        return this.create(entity);
    }

    @Override
    public Collection<BookDTO> getAllBookByTypeId(Integer typeId) throws NotFoundException {
        typeDAO.getById(typeId)
                .orElseThrow(() -> new NotFoundException("typeId", typeId.toString()));
        return _castEntitiesToDTOs(dao.getAllByType(typeId));
    }

    @Override
    public Collection<BookDTO> getAllBookByName(String queryString) throws NotFoundException {
        return _castEntitiesToDTOs(dao.getAllByName(queryString));
    }
}
