package com.example.demo.controller;
import com.example.demo.controller.EntradasController;
import com.example.demo.model.Entrada;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
@SpringBootTest
public class EntradasControllerTest {

    @Autowired
    private EntradasController entradasController;

    @Test
    @DisplayName("Prueba para verificar las entradas filtradas")
    public void testGetAllEntradasFilter() {
        List<Entrada> filteredEntradas = entradasController.getAllentradas();

        // Verificar que se encuentren las entradas filtradas esperadas
        assertThat(filteredEntradas).isNotEmpty();
        assertThat(filteredEntradas).allSatisfy(entrada -> {
            assertThat(entrada.getCategory()).isEqualTo("Animals");
            assertThat(entrada.isHTTPS()).isTrue();
        });
    }
}
