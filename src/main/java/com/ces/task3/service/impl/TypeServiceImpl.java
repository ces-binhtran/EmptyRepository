package com.ces.task3.service.impl;

import com.ces.task3.dao.TypeDAO;
import com.ces.task3.dto.TypeDTO;
import com.ces.task3.entity.TypeEntity;
import com.ces.task3.service.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends BaseServiceImpl<TypeDAO, TypeDTO, TypeEntity, Integer> implements TypeService {

    @Autowired
    public TypeServiceImpl(TypeDAO dao, ModelMapper modelMapper) {
        super(dao, modelMapper);
    }
}
