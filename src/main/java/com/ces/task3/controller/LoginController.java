package com.ces.task3.controller;


import com.ces.task3.dto.AdminDTO;
import com.ces.task3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

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
    public String form(@Valid AdminDTO adminDTO, BindingResult result, Model model) throws Exception {
        System.out.println(result.hasErrors());
        Optional<AdminDTO> adminOpt = adminService.getByEmail(adminDTO.getEmail());
        if(adminOpt.isPresent()){
            AdminDTO admin= adminOpt
                    .filter(ele -> ele.checkAccount(adminDTO))
                    .orElseThrow(() -> new Exception("User name or password not correct"));
            model.addAttribute("admin", admin);
            System.out.println(admin.getEmail() + "--"+ admin.getPassword());
        }else{
            throw new Exception("User name or password not correct");
        }
        return "login";
    }
}
