package com.ces.task3.service.impl;

import com.ces.task3.dao.AdminDAO;
import com.ces.task3.dto.AdminDTO;
import com.ces.task3.entity.AdminEntity;
import com.ces.task3.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminServiceImpl extends BaseServiceImpl<AdminDAO, AdminDTO, AdminEntity,Integer > implements AdminService{


    @Autowired
    public AdminServiceImpl(AdminDAO dao, ModelMapper modelMapper) {
        super(dao, modelMapper);
    }

    @Override
    public Optional<AdminDTO> getByEmail(String email) {
        Map<String, String> properties = new HashMap<>();
        properties.put("email", email);
        return this.getAllByProperty(properties)
                .stream()
                .findFirst();
    }


}



