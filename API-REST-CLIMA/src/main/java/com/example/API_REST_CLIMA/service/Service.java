package com.example.API_REST_CLIMA.service;

import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Service {

    private static final String BASE_URL = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current=temperature_2m,relative_humidity_2m,wind_speed_10m,wind_direction_10m&daily=temperature_2m_max,temperature_2m_min&timezone=America/Sao_Paulo";
    private static final String LOC_URL =  "https://geocoding-api.open-meteo.com/v1/search?name=%s&count=1&language=pt&format=json";

    public String consultarClima(String cidade) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String locUrl = String.format(LOC_URL, cidade.replace(" ", "%20"));
            String locGeocode = restTemplate.getForObject(locUrl, String.class);
            JsonNode locJson = objectMapper.readTree(locGeocode);
            JsonNode resultado = locJson.get("results");
            if(resultado == null){
                return "Cidade não encontrada.";
            }

            double latitude = resultado.get(0).get("latitude").asDouble();
            double longitude = resultado.get(0).get("longitude").asDouble();

            String climaURL = String.format(BASE_URL, latitude, longitude);
            return restTemplate.getForObject(climaURL, String.class);
        }catch (Exception e) {
            return "Erro ao consultar dados do clima. Tente novamente mais tarde.";
        }
    }
}