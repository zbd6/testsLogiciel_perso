package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    StatistiqueImpl statistique;

    @BeforeEach
    void init() {
        statistique = new StatistiqueImpl();   // un objet tout neuf avant chaque test
    }

    @Test
    void testPrixMoyenAvecUneVoiture() {
        statistique.ajouter(new Voiture("Peugeot", 10000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(1, echantillon.getNombreDeVoitures());
        assertEquals(10000, echantillon.getPrixMoyen());
    }

    @Test
    void testPrixMoyenAvecPlusieursVoitures() {
        statistique.ajouter(new Voiture("Peugeot", 10000));
        statistique.ajouter(new Voiture("Renault", 20000));
        statistique.ajouter(new Voiture("BMW", 30000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(3, echantillon.getNombreDeVoitures());
        assertEquals(20000, echantillon.getPrixMoyen());
    }

    @Test
    void testPrixMoyenSansVoiture() {
        // aucune voiture ajoutee -> division par zero -> ArithmeticException
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }

}
