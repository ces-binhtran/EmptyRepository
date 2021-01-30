package com.ces.task3.service;


import com.ces.task3.dto.AdminDTO;
import com.ces.task3.entity.AdminEntity;
import com.ces.task3.model.exception.LoginException;
import com.ces.task3.model.exception.NotFoundException;

public interface AdminService extends BaseService<AdminDTO, AdminEntity, Integer>{
    AdminDTO getByEmail(String email) throws LoginException, NotFoundException;
}
