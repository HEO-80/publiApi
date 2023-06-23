package com.example.demo.controller;

import com.example.demo.model.Entrada;
import com.example.demo.model.Entradas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class EntradasController {


    @GetMapping("/entradas")
    public ResponseEntity<List<Entrada>> getAllEntradas() {
        String url = "https://api.publicapis.org/entries";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Entradas> responseEntity = restTemplate.getForEntity(url, Entradas.class);
        Entradas response = responseEntity.getBody();

        List<Entrada> entradaList = response.getEntries();
        return ResponseEntity.ok().body(entradaList);
    }


    @GetMapping("/entradasfilter")
    public List<Entrada> getAllentradas() {
        List<Entrada> filteredEntradas = new ArrayList<>();

        // Obtén la lista de entradas desde alguna fuente (por ejemplo, la API externa)
        String url = "https://api.publicapis.org/entries";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Entradas> responseEntity = restTemplate.getForEntity(url, Entradas.class);
        Entradas response = responseEntity.getBody();
        List<Entrada> entradaList = response.getEntries();

        // Filtra las entradas que cumplan con los criterios deseados
        for (Entrada entrada : entradaList) {
            if (entrada.getCategory().equals("Animals") && entrada.isHTTPS()) {
                filteredEntradas.add(entrada);
            }
        }

        return filteredEntradas;
    }


}

