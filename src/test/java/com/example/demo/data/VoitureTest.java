package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.util.*;

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

    @Test
    void testerSetGetId() {
        Voiture v = new Voiture();
        v.setId(1);

        assertEquals(1, v.getId());
    }

    @Test
    void testerSetGetMarque() {
        Voiture v = new Voiture();
        v.setMarque("Renault");

        assertEquals("Renault", v.getMarque());
    }

    @Test
    void testerSetGetPrix() {
        Voiture v = new Voiture();
        v.setPrix(20000);

        assertEquals(20000, v.getPrix());
    }

    @Test
    void testerToString() {
        Voiture v = new Voiture("BMW", 30000);
        v.setId(2);

        assertEquals("Car{marque='BMW', prix=30000, id=2}", v.toString());
    }

}