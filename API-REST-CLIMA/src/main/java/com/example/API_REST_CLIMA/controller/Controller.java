package com.example.API_REST_CLIMA.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.API_REST_CLIMA.service.Service;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/clima")
    public String consultarClima(@RequestParam String cidade){
        return service.consultarClima(cidade);
    }
}

