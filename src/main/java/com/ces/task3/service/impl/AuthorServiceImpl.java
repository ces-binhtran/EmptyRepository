package com.ces.task3.service.impl;

import com.ces.task3.dao.AuthorDAO;
import com.ces.task3.dto.AuthorDTO;
import com.ces.task3.entity.AuthorEntity;
import com.ces.task3.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<AuthorDAO, AuthorDTO, AuthorEntity, Integer> implements AuthorService {

    @Autowired
    public AuthorServiceImpl(AuthorDAO dao, ModelMapper modelMapper) {
        super(dao, modelMapper);
    }
}
