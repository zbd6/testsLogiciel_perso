package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoitureAvecConstructeurVide() {
        Voiture v = new Voiture();

        assertNull(v.getMarque());
        assertEquals(0, v.getPrix());
        assertEquals(0, v.getId());
    }

    @Test
    void creerVoitureAvecConstructeurParametre() {
        Voiture v = new Voiture("Peugeot", 15000);

        assertEquals("Peugeot", v.getMarque());
        assertEquals(15000, v.getPrix());
        assertEquals(0, v.getId());
    }

}
