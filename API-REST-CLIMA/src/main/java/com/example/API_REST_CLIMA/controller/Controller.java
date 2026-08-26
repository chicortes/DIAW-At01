package com.example.API_REST_CLIMA.controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.API_REST_CLIMA.service.Service;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/climaBH")
    public String consultarClima(){
        return service.consultarClima();
    }
}

