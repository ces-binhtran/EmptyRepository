package com.ces.training.service.impl;

import com.ces.training.dao.AuthorDAO;
import com.ces.training.dto.AuthorDTO;
import com.ces.training.entity.AuthorEntity;
import com.ces.training.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String save(AuthorDTO authorDTO) {
        authorDAO.save(modelMapper.map(authorDTO, AuthorEntity.class));
        return null;
    }

    @Override
    @Transactional
    public Set<AuthorDTO> findAll() {
        Set<AuthorDTO> authorDTOList = authorDAO.findAll().stream().map(ele -> modelMapper.map(ele, AuthorDTO.class)).collect(Collectors.toSet());
        return authorDTOList;
    }
}
