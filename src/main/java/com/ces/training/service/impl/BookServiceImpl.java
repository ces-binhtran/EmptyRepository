package com.ces.training.service.impl;

import com.ces.training.dao.BookDAO;
import com.ces.training.dto.BookDTO;
import com.ces.training.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public List<BookDTO> findAll() {
        return bookDAO.findAll().stream().map(ele -> modelMapper.map(ele, BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String delete(Integer bookId) {
        return bookDAO.delete(bookId);
    }
}
