package com.ces.task3.service;


import com.ces.task3.dto.AdminDTO;
import com.ces.task3.entity.AdminEntity;

import java.util.Optional;

public interface AdminService extends BaseService<AdminDTO, AdminEntity, Integer>{
    Optional<AdminDTO> getByEmail(String email);
}
