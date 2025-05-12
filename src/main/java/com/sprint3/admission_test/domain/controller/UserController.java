package com.sprint3.admission_test.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/Pharmacist")

    public String usuario(){
        return "Acceso a Pharmacist";
    }

    @GetMapping("/admin")

    public String admin(){
        return "Acceso solo a  ADMIN";
    }
}
