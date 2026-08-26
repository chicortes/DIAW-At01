package com.example.API_REST_CLIMA.service;

import org.springframework.web.client.RestTemplate;

public class Service {

    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast?latitude=-19.9167&longitude=-43.9345&current=temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m&daily=temperature_2m_max,temperature_2m_min&timezone=America/Sao_Paulo";

    public String consultarClima() {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(BASE_URL, String.class);
        }catch (Exception e) {
            return "Erro ao consultar dados do clima. Tente novamente mais tarde.";
        }
    }
}