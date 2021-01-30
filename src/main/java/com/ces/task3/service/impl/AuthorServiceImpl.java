package com.ces.task3.service.impl;

import com.ces.task3.dao.AuthorDAO;
import com.ces.task3.dto.AuthorDTO;
import com.ces.task3.entity.AuthorEntity;
import com.ces.task3.model.exception.NotFoundException;
import com.ces.task3.model.response.Response;
import com.ces.task3.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl extends BaseServiceImpl<AuthorDAO, AuthorDTO, AuthorEntity, Integer> implements AuthorService {


    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO,
                             ModelMapper modelMapper
            ) {
        super(authorDAO, modelMapper);
    }

    @Override
    @Transactional
    public Response addAuthorsToBook(Integer bookId, List<Integer> addedAuthorIds) throws NotFoundException {
        return dao.addAuthorsToBook(bookId, addedAuthorIds);
    }

    @Override
    @Transactional
    public Response deleteAuthorsFromBook(Integer bookId, List<Integer> deleteAuthorIds) throws NotFoundException {
        return dao.deleteAuthorsFromBook(bookId, deleteAuthorIds);
    }

    @Override
    @Transactional
    public Collection<AuthorDTO> getAuthorsOffBook(Integer bookId) {
        Collection<AuthorEntity> authorDTOS = dao.getAllAuthorOfBook(bookId);
        try {
            return authorDTOS.stream()
                    .peek(author -> author.getBooks().size())// get lazy books
                    .map(toDTOFunc)
                    .collect(Collectors.toList());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }


}
