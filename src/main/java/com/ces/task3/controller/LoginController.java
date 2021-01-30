package com.ces.task3.controller;


import com.ces.task3.dto.AdminDTO;
import com.ces.task3.model.exception.LoginException;
import com.ces.task3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AdminService adminService;

    @Autowired
    public LoginController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping
    public String login(){
        return "login";
    }

    @PostMapping
    public String form(@Valid AdminDTO input, BindingResult result, Model model) throws Exception {

        AdminDTO admin = adminService.getByEmail(input.getEmail());
        if(admin.sameAccount(input)){
            model.addAttribute("admin", input);
            return "login";
        }
        throw new LoginException();
    }
}
