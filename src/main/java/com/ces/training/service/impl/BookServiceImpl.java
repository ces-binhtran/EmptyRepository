package com.ces.training.service.impl;

import com.ces.training.dao.BookDAO;
import com.ces.training.dto.BookDTO;
import com.ces.training.entity.BookEntity;
import com.ces.training.exception.AppException;
import com.ces.training.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Set<BookDTO> findAll() {
        return bookDAO.findAll().stream().map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class)).collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public String delete(Integer bookId) {
        return bookDAO.delete(bookId);
    }

    @Override
    @Transactional
    public String save(BookDTO bookDTO, Integer[] ids) {
        return bookDAO.save(modelMapper.map(bookDTO, BookEntity.class), ids);
    }

    @Override
    @Transactional
    public BookDTO get(Integer bookId) {
        try {
            return modelMapper.map(bookDAO.get(bookId), BookDTO.class);
        } catch(NullPointerException | IllegalArgumentException e) {
            throw new AppException("Not found with id " + bookId);
        }
    }

    @Override
    @Transactional
    public String update(BookDTO bookDTO, Integer[] ids) {
        BookEntity bookEntity = bookDAO.get(bookDTO.getId());
        if(bookEntity.getName().isEmpty()) {
            throw new AppException("Not found with id = " + bookEntity.getId());
        } else {
            bookEntity.setName(bookDTO.getName());
            bookEntity.setImage(bookDTO.getImage());
            bookEntity.setPrice(bookDTO.getPrice());
            bookEntity.setPublish(bookDTO.getPublish());
            return bookDAO.update(bookEntity, ids);
        }
    }

    @Override
    @Transactional
    public Set<BookDTO> findByName(String name) {
        return bookDAO.findByName(name).stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class)).collect(Collectors.toSet());
    }
}
