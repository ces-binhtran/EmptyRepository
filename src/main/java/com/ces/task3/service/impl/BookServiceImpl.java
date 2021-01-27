package com.ces.task3.service.impl;

import com.ces.task3.dao.BookDAO;
import com.ces.task3.dto.BookDTO;
import com.ces.task3.entity.BookEntity;
import com.ces.task3.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<BookDAO, BookDTO, BookEntity, Integer> implements BookService {


    @Autowired
    public BookServiceImpl(BookDAO dao, ModelMapper modelMapper) {
        super(dao, modelMapper);
    }



}
